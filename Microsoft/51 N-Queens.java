class Solution {
    public List<List<String>> solveNQueens(int n) {
        // use DFS find all posible solution
        List<List<String>> result = new ArrayList<>();
        List<Integer> layer = new ArrayList<>();

        findAll(0, n, result, layer);
        return result;
    }

    private void findAll(int index, int n, List<List<String>> result, List<Integer> layer) {
        // base case
        if (index == n) {
            List<String> newList = new ArrayList<>();
            for (Integer i : layer) {
                addQueue(newList, i, n);
            }
            result.add(newList);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(i, n, layer)) {
                layer.add(i);
                findAll(index + 1, n, result, layer);
                layer.remove(layer.size() - 1);
            }
        }
    }

    private void addQueue(List<String> list, int i, int n) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < i) {
            sb.append(".");
            index++;
        }
        sb.append("Q");
        index++;
        while (index < n) {
            index++;
            sb.append(".");
        }
        list.add(sb.toString());
    }

    private boolean isValid(int pos, int n, List<Integer> layer) {
        // same col is not valid
        int row = layer.size();
        for (int i = 0; i < layer.size(); i++) {
            int val = layer.get(i);
            if (pos == val) {
                return false;
            }
            if (Math.abs(row - i) == Math.abs(pos - val)) {
                return false;
            }
        }
        return true;
    }
}