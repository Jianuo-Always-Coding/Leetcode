class Solution {
    public void sortColors(int[] nums) {
        // corner case
        if (nums == null || nums.length <= 1) {
            return ;
        }
        int left = 0;
        int right = nums.length - 1;
        int cur = 0;
        while (cur <= right) {
            if (nums[cur] == 0) {
                swap(nums, left++, cur++);
            } else if (nums[cur] == 1) {
                cur++;
            } else {
                swap(nums, cur, right--);
            }
        }
        return ;
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}