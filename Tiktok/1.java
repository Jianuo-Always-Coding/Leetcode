class Solution {
    public int minInsertions(String s) {
        int open = 0;
        int close = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                close += 2;
                if (close % 2 != 0) {
                    close--;
                    open++;
                }
            } else if (c == ')') {
                close--;
                if (close < 0) {
                    open++;
                    close = 1;
                }
            }
        }
        return open + close;
    }
}
