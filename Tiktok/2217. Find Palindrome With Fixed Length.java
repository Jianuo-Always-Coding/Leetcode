class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        int n = queries.length;
        long[] res = new long[n];
        int start = (int) Math.pow(10, (intLength + 1) / 2 - 1);
        int end = (int) Math.pow(10, (intLength + 1) / 2);
        boolean ignoreLastDigit = intLength % 2 == 1;
        for (int i = 0; i < n; i++) {
            int val = start + queries[i] - 1;
            if (val < end) {
                long palindrome = val;
                if (ignoreLastDigit) {
                    val = val / 10;
                }
                while (val != 0) {
                    palindrome = palindrome * 10 + val % 10;
                    val = val / 10;
                }
                res[i] = palindrome;
            } else {
                res[i] = -1;
            }

        }
        return res;
    }
}
