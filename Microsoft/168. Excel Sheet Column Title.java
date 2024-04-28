class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            // 计算一下当前字母是什么
            // 我们能得到的是 0-25，代表A - Z
            int remainder = columnNumber % 26;
            // 实际上我们得到26 - Z
            if (remainder == 0) {
                remainder = 26;
                // 这样我们除才能把剩余的部分去掉
                columnNumber -= 1;
            }
            char digit = (char) ('A' + remainder - 1);
            result.insert(0, digit);
            columnNumber /= 26;
        }

        return result.toString();
    }
}