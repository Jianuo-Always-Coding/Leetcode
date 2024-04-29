class Solution {
    public int pivotIndex(int[] nums) {
        int[] prefixLeft = new int[nums.length];
        int[] prefixRight = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixLeft[i] = sum;
            sum = sum + nums[i];
        }

        sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            prefixRight[i] = sum;
            sum = sum + nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (prefixLeft[i] == prefixRight[i]) {
                return i;
            }
        }
        return -1;
    }
}