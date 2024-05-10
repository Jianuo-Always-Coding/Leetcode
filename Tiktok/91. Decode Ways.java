class Solution {
    public int numDecodings(String s) {
        // corner case
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        if (s.charAt(0) == '0') {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int[] dp = new int[s.length() + 1]; // 长度为index的字符串有几种解码方式
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            int val = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
            if (val >= 10 && val <= 26) {
                dp[i] += dp[i - 2]; 
            } 
            if (s.charAt(i - 1) - '0' > 0) {
                dp[i] += dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }
}
