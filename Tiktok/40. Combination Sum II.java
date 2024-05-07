class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // corner case
        if (candidates == null || candidates.length == 0) {
            return result;
        }

        List<Integer> layer = new ArrayList<>();
        Set<Integer> set = new HashSet<>(); // 已经考虑过的元素直接跳过，因为已经包含在第一次出现这个元素的结果中了
        helper(candidates, target, 0, set, layer, result);
        return result;
    }

    private void helper(int[] candidates, int target, int index, Set<Integer> set, List<Integer> layer, List<List<Integer>> result) {
        // base case
        if (index == candidates.length) {
            if (target == 0) {
                result.add(new ArrayList<>(layer));
            }
            return ;
        }

        if (target >= candidates[index] && !set.contains(candidates[index])) {
            layer.add(candidates[index]);
            helper(candidates, target - candidates[index], index + 1, set, layer, result);
            layer.remove(layer.size() - 1);
            set.add(candidates[index]);
            helper(candidates, target, index + 1, set, layer, result);
            set.remove(candidates[index]); // 一定要remove layer 和 set
        } else {
            helper(candidates, target, index + 1, set, layer, result);
        }
    }
}
