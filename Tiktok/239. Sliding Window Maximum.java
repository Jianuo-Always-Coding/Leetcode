class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>(); // 维护一个单调递减栈
        int[] result = new int[nums.length - k + 1]; // 记录结果

        // 初始化window
        for (int i = 0; i < k; i++) { 
            addToDeque(deque, nums[i]);
        }

        result[0] = deque.peekFirst();

        int left = 0;
        int right = k;
        while (right < nums.length) {
            // 移动窗口， 第一个数字应该移除
            if (deque.peekFirst() == nums[left]) {
                deque.pollFirst();
            }
            left++;
            // 将后面的数字加入
            addToDeque(deque, nums[right++]);
            // 加入结果
            result[left] = deque.peekFirst();
        }
        return result;

    }


    // 将值加入栈
    private void addToDeque(Deque<Integer> deque, int num) {
        // 如果栈为空，直接入栈
        while (!deque.isEmpty()) {
            // 如果不是大于，直接加入
            if (deque.peekLast() >= num) {
                deque.offerLast(num);
                return ;
            }
            // 如果没办法维护单调递减的栈，那就弹出
            deque.pollLast();
        }
        deque.offerLast(num);
    }
}
