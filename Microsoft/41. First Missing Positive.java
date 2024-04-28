class Solution {
    public int firstMissingPositive(int[] nums) {
        int index = 0;
        while (index < nums.length) {
            // nums[index] == nums[nums[index]] 表示已经有正确的数在当前位置上了
            if (nums[index] <= 0 || nums[index] >= nums.length || nums[index] == nums[nums[index]]) {
                index++;
            } else {
                swap(index, nums[index], nums);
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != i)
                return i;
        }
        // 证明1到最后都匹配了
        // 看异一下最后一个数是否匹配
        if (nums[0] != nums.length)
            return nums.length;
        return nums.length + 1;
    }

    private void swap(int a, int b, int[] nums) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}