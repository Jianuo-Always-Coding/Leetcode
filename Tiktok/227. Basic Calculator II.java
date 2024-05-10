class Solution {
    public int calculate(String s) {
        Deque<Character> operators = new ArrayDeque<>(); // 存放符号
        Deque<Integer> numbers = new ArrayDeque<>(); // 存放数字
        int number = 0; // 得到一整个数的值

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 是数字，累加
            if (Character.isDigit(c)) {
                number = number * 10 + c - '0';
            // 是空格，过    
            } else if (c == ' ') {
                continue;
            // 是运算符，
            // 如果是空，数字和运算符直接入栈，并重置number
            } else if (operators.isEmpty()) {
                numbers.offerFirst(number);
                operators.offerFirst(c);
                number = 0;
            // 是运算符，但是运算符的栈中有东西
            } else {
                // 把前面计算好的数字放入栈中，重置number
                numbers.offerFirst(number);
                number = 0;
                // 如果前面的运算符优先级大于等于当前的，先计算前面所有，直到为空或者优先级比当前运算符小
                while (!operators.isEmpty() && priority(operators.peekFirst()) >= priority(c)) {
                    int num2 = numbers.pollFirst();
                    int num1 = numbers.pollFirst();
                    numbers.offerFirst(cal(num1, num2, operators.pollFirst()));
                }
                operators.offerFirst(c); // 把当前运算符入栈
            }
        }
        
        // 如果没算完，一直计算
        while (!operators.isEmpty()) {
            number = cal(numbers.pollFirst(), number, operators.pollFirst());
        }
        // 返回结果
        return number;
    }

    // 计算两数字的运算结果
    private int cal(int a, int b, char o) {
        if (o == '+') {
            return a + b;
        } else if (o == '-') {
            return a - b;
        } else if (o == '*') {
            return a * b;
        } else {
            return a / b;
        }
    }

    // 计算优先级
    private int priority(char c) {
        if (c == '+' || c == '-') {
            return 0;
        }
        return 1;
    }
}
