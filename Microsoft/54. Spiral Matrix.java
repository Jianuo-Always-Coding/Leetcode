class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // control four variable left, right, up and down, for loop to print
        // if M != N, need to deal with corner case
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return result;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int up = 0;
        int left = 0;
        int right = cols - 1;
        int down = rows - 1;
        while (left < right && up < down) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);
            }
            for (int i = up + 1; i <= down - 1; i++) {
                result.add(matrix[i][right]);
            }
            for (int i = right; i >= left; i--) {
                result.add(matrix[down][i]);
            }
            for (int i = down - 1; i >= up + 1; i--) {
                result.add(matrix[i][left]);
            }
            left++;
            right--;
            up++;
            down--;
        }
        if (left > right || up > down) {
            return result;
        }
        // only have one col
        if (left == right) {
            for (int i = up; i <= down; i++) {
                result.add(matrix[i][left]);
            }
        } else {
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);
            }
        }
        return result;
    }
}
