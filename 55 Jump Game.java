class Solution {
    public boolean canJump(int[] nums) {
        // corner case
        if (nums == null || nums.length <= 1) {
            return true;
        }
        boolean[] canArrive = new boolean[nums.length];
        int n = nums.length;
        canArrive[0] = true;

        for (int i = 0; i < n; i++) {
            if (canArrive[i]) {
                if (i + nums[i] >= n - 1) {
                    return true;
                }
                for (int j = 1; j <= nums[i]; j++) {
                    canArrive[i + j] = true;
                }
            }
            
        }
        return canArrive[n - 1];
    }
}