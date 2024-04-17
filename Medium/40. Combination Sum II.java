class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> layer = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        helper(result, layer, set, target, 0, candidates);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> layer, Set<Integer> set, int target, int index, int[] candidates) {
        // base case
        if (index == candidates.length) {
            if (target == 0) {
                result.add(new ArrayList<>(layer));
            }
            return ;
        }

        if (candidates[index] <= target && !set.contains(candidates[index])) {
            layer.add(candidates[index]);
            helper(result, layer, set, target - candidates[index], index+1, candidates);
            layer.remove(layer.size() - 1);
            set.add(candidates[index]);
            helper(result, layer, set, target, index+1, candidates);
            set.remove(candidates[index]);
        } else {
            helper(result, layer, set, target, index+1, candidates);
        }
    }
}