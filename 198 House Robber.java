class Solution {
    public int rob(int[] nums) {
        // corner case
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int cur = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}