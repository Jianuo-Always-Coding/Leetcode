class Solution {
    public boolean predictTheWinner(int[] nums) {
        // corner case 
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        int result = helper(dp, 0, n - 1, nums);
        if (result >= 0) {
            return true;
        }
        return false;
    }

    private int helper(int[][] dp, int left, int right, int[] nums) {
        if(left == right) {
            return nums[left];
        }
        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        int x = nums[left] - helper(dp, left + 1, right, nums);
        int y = nums[right] - helper(dp, left, right - 1, nums);
        dp[left][right] = Math.max(x, y);
        return dp[left][right];
        
    }
}