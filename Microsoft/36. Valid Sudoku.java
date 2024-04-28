class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 对于每一个数字，判断是否valid
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!isValid(i, j, board)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    boolean isValid(int x, int y, char[][] board) {
        char n = board[x][y];
        for (int i = 0; i < 9; i++) {
            if (board[i][y] == n && i != x) {
                return false;
            }
            if (board[x][i] == n && i != y) {
                return false;
            }
            // 不是同一行不是同一列，但是等于val也不行
            if (board[(x / 3) * 3 + i / 3][(y / 3) * 3 + i % 3] == n && ((x / 3) * 3 + i / 3 != x)
                    && (y / 3) * 3 + i % 3 != y) {
                return false;
            }
        }
        return true;
    }
}