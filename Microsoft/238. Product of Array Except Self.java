class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        Arrays.fill(res, 1);
        int current = 1;
        // 计算这个数左面的所有乘积
        for (int i = 0; i < nums.length; i++) {
            res[i] = current;
            current *= nums[i];
        }

        current = 1;
        // 从右面开始遍历，再乘上左面的
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= current;
            current *= nums[i];
        }
        return res;
    }
}
        