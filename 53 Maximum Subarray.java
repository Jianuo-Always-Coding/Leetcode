class Solution {
    public int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (prev < 0) {
                prev = nums[i];
            } else {
                prev = prev + nums[i];
            }
            max = Math.max(max, prev);

        }
        return max;
        
    }
}