// 以下是简化版本
/**
class Solution {
    public int minFlipsMonoIncr(String s) {
        
        int count = 0;
        int count1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                count++;
            } else {
                count1++;
            }
            count = Math.min(count, count1);
        }
        return count;
    }
}
 */

class Solution {
    public int minFlipsMonoIncr(String s) {
        // 使用DP思想
        // 创建一个dp[][2],第一列代表所有都是0，第二列代表最后一个是1，但是含有多少个0不知道
        // corner case
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[][] dp = new int[s.length()][2];
        if (s.charAt(0) == '1') {
            dp[0][0] = 1;
        }

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i - 1][1]) + 1; // 需要反转成1
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]);
            }             
        }
        return Math.min(dp[dp.length - 1][0], dp[dp.length -1][1]);
    }
}
