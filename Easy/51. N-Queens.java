class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<Integer> layer = new ArrayList<>();
        helper(0, result, layer, n);
        return result;
    }

    private void helper(int index, List<List<String>> result, List<Integer> layer, int n) {
        // base case
        if (layer.size() == n) {
            addToResult(result, layer);
            return ;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(layer, i, n)) {
                layer.add(i);
                helper(index+1, result, layer, n);
                layer.remove(layer.size() - 1);
            }
        }
    }

    private boolean isValid(List<Integer> layer, int index, int n) {
        for (int row = 0; row < layer.size(); row++) {
            int col = layer.get(row);
            if (col == index) {
                return false;
            }
            if (Math.abs(col - index) == Math.abs(layer.size() - row)) {
                return false;
            }
        }
        return true;
    }

    private void addToResult(List<List<String>> result, List<Integer> layer) {
        int n = layer.size();
        char[] list = new char[n];
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list[i] = '.';
        }
        for (int i = 0; i < layer.size(); i++) {
            int index = layer.get(i);
            list[index] = 'Q';
            answer.add(new String(list));
            list[index] = '.';
        }
        result.add(answer);
    }
}