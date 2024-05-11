class Solution {
    public boolean increasingTriplet(int[] nums) {
        // start with two largest values, and update once we can find two smaller values
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int num:nums) {
            // 更新small的同时，也不会丢掉第二大的边界
            if (num <= small) {small = num;}
            else if (num <= big) {big = num;}
            // we find a number bigger than both
            else return true;
        }
        return false;
    }
}
