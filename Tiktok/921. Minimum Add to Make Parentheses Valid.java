class Solution {
    public int minAddToMakeValid(String s) {
        int needLeft = 0, needRight = 0; // 初始化左右括号的需求数量

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // 如果遇到左括号，增加一个右括号的需求
                needRight += 1;
            } else if (s.charAt(i) == ')') {
                // 如果遇到右括号
                if (needRight > 0) {
                    // 如果有右括号的需求，则减少一个右括号的需求
                    needRight -= 1;
                } else {
                // 如果没有右括号的需求，则增加一个左括号的需求
                    needLeft += 1;
                }
            } 
        }

    // 返回添加的左括号和右括号的总数，使字符串有效
    return needLeft + needRight;
    }

}
