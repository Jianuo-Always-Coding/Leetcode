class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // corner case
        int result = 0;

        int left = 0; 
        int right = 0;
        int sum = 0;
        while (right < nums.length) {
            if (sum < target) {
                sum = sum + nums[right++];
            } else {
                result = result == 0 ? right - left : Math.min(result, right - left);
                sum = sum - nums[left++];
            } 
        }
        while (sum >= target) {
            result = result == 0 ? right - left : Math.min(result, right - left);
            sum = sum - nums[left++];
        }
        
        return result;
    }
}
