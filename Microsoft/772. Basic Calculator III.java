class Solution {
    public int calculate(String s) {
        // 创建一个栈用于存储中间结果
        Stack<Integer> stack = new Stack<>();
        // 初始化符号为'+'
        char sign = '+';
        // 初始化数字
        int num = 0;
        // 遍历字符串
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果是数字，更新数字值
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            // 如果遇到左括号
            if (c == '(') {
                int j = i + 1, braces = 1;
                // 找到对应的右括号的位置
                for (; j < s.length(); j++) {
                    if (s.charAt(j) == ')')
                        braces--;
                    if (s.charAt(j) == '(')
                        braces++;
                    // 如果左右括号数量相等，说明找到了对应的右括号
                    if (braces == 0)
                        break;
                }
                // 对括号内的表达式进行递归计算
                num = calculate(s.substring(i + 1, j));
                // 更新i，跳过括号内的表达式
                i = j;
            }
            // 如果遇到运算符或者已经到达字符串末尾
            if (c == '+' || c == '-' || c == '*' || c == '/' || i == s.length() - 1) {
                // 根据之前记录的符号对数字进行处理并入栈
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    // 出栈一个数字与当前数字相乘后入栈
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    // 出栈一个数字与当前数字相除后入栈
                    stack.push(stack.pop() / num);
                }
                // 重置数字
                num = 0;
                // 更新符号
                sign = c;
            }
        }
        // 将栈中的元素相加得到结果
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}