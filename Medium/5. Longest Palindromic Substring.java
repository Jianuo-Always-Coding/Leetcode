class Solution {
    public String longestPalindrome(String s) {
        // corner case
        if (s == null || s.length() == 0) {
            return s;
        }
        int n = s.length();
        int start = 0;
        int end = 0;

        boolean[][] isPalindrom = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            isPalindrom[i][i] = true;
            if (i < n - 1) {
                isPalindrom[i + 1][i] = true;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && isPalindrom[i + 1][j - 1]) {
                    isPalindrom[i][j] = true;
                    if (j - i > end - start) {
                        start = i;
                        end = j;
                    }
                } 
            }
        }
        return s.substring(start, end + 1);
    }
}