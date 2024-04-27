class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        // left is the first number, right is the last(not contains)

        while (right < nums.length) {
            sum += nums[right];
            // 达到条件，更新结果，移动left
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
            right++;
        }
        if (result == Integer.MAX_VALUE) {
            return 0;
        }
        return result;
    }
}