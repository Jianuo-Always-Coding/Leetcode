class Solution {
    public int myAtoi(String s) {
        long ans = 0; //存在超界 用long，加完判断判断
        boolean negative = false;
        boolean digitRead = false;
        boolean sign = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                continue;
            }
            // 多个加减号只要第一个
            if (ch == '+' || ch == '-') {
                if (sign) {
                    break;
                }
                if (ch == '-') {
                    negative = true;
                }
                sign = true;
                continue;
            }
            if (!Character.isDigit(ch)) {
                break;
            }
            ans = ans * 10 + ch - '0';
            // 如果负数的话是max_value + 1 但是的话就符合条件了
            if (ans > Integer.MAX_VALUE) {
                if (negative) {
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            }
        }
        if (negative) {
            ans = -ans;
        }
        return (int)ans;
    }
}