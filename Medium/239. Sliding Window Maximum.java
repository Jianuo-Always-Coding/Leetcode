class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) { 
            addToDeque(deque, nums[i]);
        }

        result[0] = deque.peekFirst();
        System.out.println(deque.toString());
        int left = 0;
        int right = k;
        while (right < nums.length) {
            if (deque.peekFirst() == nums[left]) {
                deque.pollFirst();
            }
            left++;
            addToDeque(deque, nums[right++]);
            result[left] = deque.peekFirst();

        }
        return result;

    }

    private void addToDeque(Deque<Integer> deque, int num) {
        while (!deque.isEmpty()) {
            if (deque.peekLast() >= num) {
                deque.offerLast(num);
                return ;
            }
            deque.pollLast();
        }
        deque.offerLast(num);
    }
}