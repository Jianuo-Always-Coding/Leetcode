class Solution {
    public boolean canJump(int[] nums) {
        // corner case
        if (nums == null || nums.length <= 1) {
            return true;
        }
        // 能否跳到
        boolean[] canArrive = new boolean[nums.length];
        int n = nums.length;
        canArrive[0] = true;

        for (int i = 0; i < n; i++) {
            if (canArrive[i]) {
                // 是否跳超过
                if (i + nums[i] >= n - 1) {
                    return true;
                }
                // 把能到达的位置都变为true
                for (int j = 1; j <= nums[i]; j++) {
                    canArrive[i + j] = true;
                }
            }
            
        }
        return canArrive[n - 1];
    }
}