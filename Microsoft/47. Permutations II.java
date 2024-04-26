class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, result);
        return result;
    }

    private void helper(int[] nums, int index, List<List<Integer>> result) {
        // base case
        if (index == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (Integer i : nums) {
                list.add(i);
            }
            result.add(list);
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (set.add(nums[i])) {
                swap(nums, index, i);
                helper(nums, index + 1, result);
                swap(nums, index, i);
            }
        }
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}