class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Assumption: Input Strings are not null
        // 是否要全部用完
        // induction rule ： 只可能向右向下走
            // if dp[i][j] == true: 
            //     if (s1.charAt(i) == s3.charAt(i + j)) put into queue
            //     if (s2.charAt(i) == s3.charAt(i + j)) put into queue

        // corner case
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        if (s3.length() == 0) {
            return true;
        }
        if (s1.length() == 0) {
            return s3.equals(s2);
        }
        if (s2.length() == 0) {
            return s3.equals(s1);
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0,0});

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int i = pos[0];
            int j = pos[1];
            if (i == s1.length() && j == s2.length()) {
                return true;
            }
            if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
                q.offer(new int[] {i + 1, j});
            }
            if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
                q.offer(new int[] {i, j + 1});
            }
            
        }
        return false;
    }
}