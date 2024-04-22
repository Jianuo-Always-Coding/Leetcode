class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;
        int value = 0;
        int signal = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                value = value * 10 + c - '0';
            } else if (c == '+' || c == '-') {
                result = result + signal * value;
                value = 0;
                signal = c == '+' ? 1 : -1;
            } else if (c == '(') {
                stack.offerFirst(result);
                stack.offerFirst(signal);
                result = 0;
                signal = 1;
            } else if (c == ')') {
                // 把当前的加完
                result += signal * value; 
                int signalTmp = stack.pollFirst();
                int resultTmp = stack.pollFirst();
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