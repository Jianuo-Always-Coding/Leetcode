class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        // dp[i][j] 表示字符串 s 的前 i 个字符和模式串 p 的前 j 个字符是否匹配
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true; // 空字符串与空模式串是匹配的

        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) { // 从第一个字符开始比较
                // 如果 p 的第 j 个字符是 '*'，则需要考虑 '*' 匹配零个前面的元素或者匹配一个或多个前面的元素的情况
                if (p.charAt(j - 1) == '*') {
                    // dp[i][j - 2]：第一种情况，'*' 匹配零个前面的元素
                    // (i > 0 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j])：
                    // '*' 匹配一个或多个前面的元素。这时，需要满足以下条件：
                    // 1. i > 0：确保 s 的前 i 个字符非空，避免数组越界。
                    // (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')：检查当前字符是否与 '*' 前面的字符匹配，即 s.charAt(i-1) == p.charAt(j-2) 或者 p.charAt(j-2) == '.'。
                    // dp[i - 1][j]：查看上一个状态 dp[i-1][j] 的值，表示 '*' 匹配一个或多个前面的元素的情况。
                    dp[i][j] = dp[i][j - 2] || (i > 0 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j]);
                } else {
                    // 如果不是*的话看一下是否匹配
                    // i = 0的话没有字符不会匹配
                    // 是否相等是否等于‘.，并且之前的字符是否相等
                    dp[i][j] = i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') && dp[i - 1][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}