class Solution {
    public boolean find132pattern(int[] nums) {
        int s3 = Integer.MIN_VALUE; // 最右面的数设置为最小值
        Deque<Integer> deque = new ArrayDeque<>();

        // 逆序遍历数组
        for (int i = nums.length - 1; i >= 0; i--) {
            // 当前数比s3小，找到了
            if (nums[i] < s3) {
                return true;
            } else {
                // 更新s3的值
                while (!deque.isEmpty() && nums[i] > deque.peekFirst()) {
                    s3 = deque.removeFirst();
                }
                deque.addFirst(nums[i]);
            }
        }

        return false;
    }
}
