class Solution {
    public int findClosestNumber(int[] nums) {
        // corner case
        int val = nums[0];
        int res = Math.abs(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (Math.abs(nums[i]) < res) {
                res = Math.abs(nums[i]);
                val = nums[i];
            } else if (Math.abs(nums[i]) == res) {
                if (nums[i] > val) {
                    res = Math.abs(nums[i]);
                    val = nums[i];
                }
            }
        }
        return val;
    }
}