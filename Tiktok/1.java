class Solution {
    public int minInsertions(String s) {
        int l = 0, r = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                r += 2; // 需要的右括号加2
            } else {
                r -= 1;
                // 没有右括号，需要加一个左括号和一个右括号
                if (r == -1) {
                    r = 1;
                    l += 1;
                }
            }
        }
        return l + r;
    }
}
