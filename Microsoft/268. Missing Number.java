class Solution {
    public int missingNumber(int[] nums) {
        // 考虑超出界限
        int val = 0;
        for (int i = 0; i < nums.length; i++) {
            val = val ^ i;
            val = val ^ nums[i];
        }        
        val = val ^ nums.length;
        return val;
    }
}