class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(rob0(nums), rob1(nums));
    }
    // 从0到倒数第二个，最后一个不能偷
    private int rob0(int[] nums){
        int preMax = 0, curMax = 0;
        for(int i = 0; i <nums.length -1; i++){
            int t = curMax;
            curMax = Math.max(preMax + nums[i], curMax);
            preMax = t;
        }
        return curMax;
    }

    // 从1到最后，第一个不能偷
    private int rob1(int[] nums){
        int preMax = 0, curMax = 0;
        for(int i = 1; i< nums.length; i++){
            int t = curMax;
            curMax = Math.max(preMax + nums[i], curMax);
            preMax = t;
        }
        return curMax;
    }
}