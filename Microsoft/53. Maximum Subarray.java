class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        int sum = nums[0];
        for (int i=1; i<n; i++) {
            if (sum > 0) {
                sum += nums[i];
                
            } else {
                sum = nums[i];
            }
            res = Math.max(res, sum);
            
        }
        return res;
    }
}

// -2 1 -3 4 -1 2 1 -5 4
// [1 + -3] => -2