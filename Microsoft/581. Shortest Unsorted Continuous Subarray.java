class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int end = -1;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 先找结尾，如果这个数比之前最大的要小，肯定要重排序
            if (max > nums[i]) {
                end = i;
            } else
            // 更新 max的值
                max = nums[i];
        }
        int start = 0;
        int min = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            // 找开头，当前值比右面最小要大，要重排序
            if (min < nums[i])
                start = i;
            else
            // 更新
                min = nums[i];
        }
        return end - start + 1;
    }
}