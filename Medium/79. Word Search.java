class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean[] result = new boolean[1];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    find(visited, i, j, word, board, 1, result);
                    visited[i][j] = false;
                    if (result[0]) {
                        return result[0];
                    }
                }
            }
        }
        return false;
    }

    private void find(boolean[][] visited, int x, int y, String word, char[][] board, int index, boolean[] result) {
        if (result[0] || index == word.length()) {
            result[0] = true;
            return ;
        }

        if (x > 0 && !visited[x - 1][y] && board[x - 1][y] == word.charAt(index)) {
            visited[x - 1][y] = true;
            find(visited, x - 1, y, word, board, index + 1, result);
            visited[x - 1][y] = false;
        }
        if (x < board.length - 1 && !visited[x + 1][y] && board[x + 1][y] == word.charAt(index)) {
            visited[x + 1][y] = true;
            find(visited, x + 1, y, word, board, index + 1, result);
            visited[x + 1][y] = false;
        }
        if (y > 0 && !visited[x][y - 1] && board[x][y - 1] == word.charAt(index)) {
            visited[x][y - 1] = true;
            find(visited, x, y - 1, word, board, index + 1, result);
            visited[x][y - 1] = false;
        }
        if (y < board[0].length - 1 && !visited[x][y + 1] && board[x][y + 1] == word.charAt(index)) {
            visited[x][y + 1] = true;
            find(visited, x, y + 1, word, board, index + 1, result);
            visited[x][y + 1] = false;
        }
    }
}