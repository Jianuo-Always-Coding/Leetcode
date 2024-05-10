class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>(); // 保存符号和result
        int result = 0; // 保存当前的结果
        int value = 0; //计算这个数字到底多大
        int signal = 1; // 记录符号，1代表+，-1代表-
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 是数字的话累加计算
            if (Character.isDigit(c)) {
                value = value * 10 + c - '0'; 
            // 是符号的话，result加上这个符号之前应该计算的结果
            // 更新 value
            // 更新符号位
            } else if (c == '+' || c == '-') {
                result = result + signal * value;
                value = 0;
                signal = c == '+' ? 1 : -1;
            // 如果是括号的话应该把前面的result和符号保存起来
            } else if (c == '(') {
                stack.offerFirst(result);
                stack.offerFirst(signal);
                // 重置
                result = 0;
                signal = 1;
            } else if (c == ')') {
                // 把当前的加完
                result += signal * value; 
                // 把前面计算的结果拿出来
                int signalTmp = stack.pollFirst();
                int resultTmp = stack.pollFirst();
                // 更新计算结果
                result = resultTmp + signalTmp * result;
                value = 0;
            }
        }
        if (value != 0) {
            result = result + signal * value;
        }
        return result;
    }
}
