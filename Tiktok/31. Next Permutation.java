class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        

        // 从右面数，找到第一个不是降序的数字的index
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // 如果没找到说明是最大的，reverse就可以
        if (i == -1) {
            reverse(nums, 0);
            return ;
        }
        // 找到了, 找最靠近右面的一个比他大的数交换
        if (i >= 0) {
            // Find the largest index（最靠右面） j greater than i such that nums[i] < nums[j]
            int j = nums.length - 1;
            while (j >= i && nums[i] >= nums[j]) {
                j--;
            }
            // Swap nums[i] and nums[j]
            swap(nums, i, j);
        }
        // Reverse the sub-array nums[i + 1:]， 从最小升序开始
        reverse(nums, i + 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}

