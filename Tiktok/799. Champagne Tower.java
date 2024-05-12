class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        // 模仿倒水的过程
        double[][] dp = new double[query_row + 1][query_row + 1];
        dp[0][0] = (double) poured;
        for (int i = 0; i < query_row; i++) {
            for (int j = 0; j <= i; j++) {
                // 往一边溢出的水有多少
                double overFlow = (dp[i][j] - 1.0) / 2.0;
                // 有水溢出，加入
                if (overFlow > 0) {
                    dp[i + 1][j] += overFlow;
                    dp[i + 1][j + 1] += overFlow;
                }
            }
        }
        // 有可能大于1
        return Math.min(1, dp[query_row][query_glass]);

    }
}
