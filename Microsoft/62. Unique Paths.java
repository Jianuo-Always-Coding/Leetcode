
class Solution {

    public int uniquePaths(int m, int n) {

        if(m == 0 || n == 0) return 0;
        int[][] DP = new int[m][n];

        // initalization 
        // 横着走和竖着走都只能是1
        for(int i = 0; i < m; i++){
            DP[i][0] = 1;
        }
        for(int j = 1; j < n; j++){
            DP[0][j] = 1;
        }
        // 当前位置可以从上面和左面过来
        for(int i = 1; i < m; i++){
            for(int j = 1; j< n; j++){
                DP[i][j] = DP[i-1][j]+DP[i][j-1];
            }
        }
        return DP[m - 1][n - 1];
    }

}