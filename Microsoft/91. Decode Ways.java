class Solution {
    public int numDecodings(String s) {
      int n = s.length();
      int[] dp = new int[n + 1]; // 包含n个字母
      dp[0] = 1; // 空消息本身是一种解法
      if (s.charAt(0) == '0') {
        dp[1] = 0;
      } else {
        dp[1] = 1;
      }

      for (int i = 2; i <= n; i++) {
        // 一个字符
        if (s.charAt(i - 1) != '0') {
            dp[i] += dp[i - 1];
        }
        // 两个字符合法性
        int val = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
        if ( val >= 10 && val <= 26) {
            dp[i] += dp[i - 2];
        }
      }
      return dp[n];
    }
}