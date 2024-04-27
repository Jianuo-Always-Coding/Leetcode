class Solution {
    public void moveZeroes(int[] nums) {
        // corner case
        if (nums == null || nums.length <= 1) {
            return ;
        }
        int left = 0; //记录不是0的
        int right = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                right++;
            } else {
                nums[left++] = nums[right++];
            }
        }

        // 把剩下的都变为0
        while (left < nums.length) {
            nums[left++] = 0; 
        }
        // return nums;
    }

}