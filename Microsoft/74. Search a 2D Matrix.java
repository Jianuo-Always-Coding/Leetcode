class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // corner case
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int rowNum = matrix.length;
        int colNum = matrix[0].length;

        int left = 0;
        int right = rowNum * colNum - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / colNum;
            int col = mid % colNum;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}