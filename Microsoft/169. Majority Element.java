class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        int count = 1, ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (ans == nums[i]) {
                count++;
            } else if (count > 0) {
                count--;
            } else {
                ans = nums[i];
                count = 1;
            }
        }
        return ans;
    }
}