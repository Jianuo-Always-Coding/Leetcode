class TicTacToe {
    int[] rows;
    int[] cols;
    int diag;
    int antiDiag;
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diag = 0;
        antiDiag = 0;
    }        
    
    public int move(int row, int col, int player) {
        int n = rows.length, score = player == 1 ? 1 : -1;
        rows[row] += score;
        cols[col] += score;
        if (row == col) diag += score;
        if (row + col == n - 1) antiDiag += score;
        if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diag) == n || Math.abs(antiDiag) == n) return player;
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */