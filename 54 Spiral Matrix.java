class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        printNode(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, result);
        return result;
    }

    private void printNode(int[][] matrix, int r1, int c1, int r2, int c2, List<Integer> result) {

        if (r1 > r2 || c1 > c2) {
            return ;
        }
        // base case
        if (r1 == r2) {
            for (int c = c1; c <= c2; c++) {
                result.add(matrix[r1][c]);
                
            }
            return ;
        }

        if (c1 == c2) {
            for (int r = r1; r <= r2; r++) {
                result.add(matrix[r][c1]);
            }
            return ;
        }

        for (int c = c1; c < c2; c++) {
            result.add(matrix[r1][c]);
        }

        for (int r = r1; r < r2; r++) {
            result.add(matrix[r][c2]);
        }

        for (int c = c2; c > c1; c--) {
            result.add(matrix[r2][c]);
        }

        for (int r = r2; r > r1; r--) {
            result.add(matrix[r][c1]);
        }
        printNode(matrix, r1 +1, c1 + 1, r2 - 1, c2 - 1, result);
    }
}