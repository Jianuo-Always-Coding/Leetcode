class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> layer = new ArrayList<>();
        helper(result, layer, candidates, 0, target);
        return result;
    }


    private void helper(List<List<Integer>> result, List<Integer> layer, int[] candidates, int index, int rest) {
        // base case
        if (index == candidates.length - 1 && rest % candidates[candidates.length - 1] == 0) {
            int count = rest / candidates[candidates.length - 1];
            for (int i = 0; i < count; i++) {
                layer.add(candidates[candidates.length - 1]);
            }
            result.add(new ArrayList<>(layer));
            for (int i = 0; i < count; i++) {
                layer.remove(layer.size() - 1);
            }
            return ;
        } else if (index == candidates.length - 1) {
            return ;
        }


        int count = rest / candidates[index];
        helper(result, layer, candidates, index + 1, rest);
        for (int i = 1; i <= count; i++) {
            layer.add(candidates[index]);
            helper(result, layer, candidates, index + 1, rest - candidates[index] * i);
        }
        for (int i = 0; i < count; i++) {
            layer.remove(layer.size() - 1);
        }



    }
}