class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        int n = queries.length; // 需要计算n个数
        long[] res = new long[n]; // 存放结果的数组
        int start = (int) Math.pow(10, (intLength + 1) / 2 - 1); // 前半段开始的数
        int end = start * 10; // 前半段结束的边界
        boolean ignoreLastDigit = intLength % 2 == 1; // 是否是奇数，忽略前半段最后一个数

        // 找到每一个结果
        for (int i = 0; i < n; i++) {
            int val = start + queries[i] - 1;
            // 可行
            if (val < end) {
                long palindrome = val;
                if (ignoreLastDigit) {
                    val = val / 10;
                }
                // 加入结果
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
