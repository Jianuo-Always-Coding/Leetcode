class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        int index = 0;
        int start = lower;
        int end = upper;
        List<List<Integer>> result = new ArrayList<>();

        while (index < nums.length) {
            if (nums[index] == start) {
                start++;
                index++;
            } else if (nums[index] < start) {
                index++;
            } else {
                result.add(Arrays.asList(start, nums[index] - 1));
                start = nums[index] + 1;
                index++;
            }
        }
        if (start <= end) {
            result.add(Arrays.asList(start, end));
        }
        return result;
    }
}