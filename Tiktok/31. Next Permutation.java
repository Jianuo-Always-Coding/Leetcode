class Solution {
    public void nextPermutation(int[] nums) {
        // corner case
        if (nums == null || nums.length <= 1) {
            return ;
        }

        // 找到从右面数第一个小于前一个的数的位置（大于等于都不行）
        int index1 = nums.length - 2;
        while (index1 >= 0) {
            if (nums[index1] >= nums[index1 + 1]) {
                index1--;
            } else {
                break;
            }
        }

        // 全部降序
        if (index1 == -1) {
            reverse(nums, 0, nums.length - 1);
            return ;
        }

        // 找到最靠右面第一个比index大的数
        int index2 = nums.length - 1;
        while (index2 >= 0) {
            if (nums[index2] <= nums[index1]) {
                index2--;
            } else {
                break;
            }
        }
        if (index2 == -1) {
            return ;
        }
        swap(nums, index1, index2);
        reverse(nums, index1 + 1, nums.length - 1);
        return ;
    }

    private void reverse(int[] array, int start, int end) {
        while (start  < end) {
            swap(array, start++, end--);
        }
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
