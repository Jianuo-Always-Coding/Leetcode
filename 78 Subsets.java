class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // corner case
        if (nums == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> layer = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        helper(nums, 0, result, layer);
        return result; 
    }

    private void helper(int[] nums, int index, List<List<Integer>> result, List<Integer> layer) {
        // base case
        if (index == nums.length) {
            result.add(new ArrayList<>(layer));
            return;
        }

        helper(nums, index + 1, result, layer);
        layer.add(nums[index]);
        helper(nums, index + 1, result, layer);
        layer.remove(layer.size() - 1);
    }
}