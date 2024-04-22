class Solution {
    public int calculate(String s) {
        Deque<Character> operators = new ArrayDeque<>();
        Deque<Integer> numbers = new ArrayDeque<>();
        int number = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = number * 10 + c - '0';
            } else if (c == ' ') {
                continue;
            } else if (operators.isEmpty()) {
                numbers.offerFirst(number);
                number = 0;
                operators.offerFirst(c);
            } else {
                numbers.offerFirst(number);
                number = 0;
                while (!operators.isEmpty() && priority(operators.peekFirst()) >= priority(c)) {
                    int num2 = numbers.pollFirst();
                    int num1 = numbers.pollFirst();
                    numbers.offerFirst(cal(num1, num2, operators.pollFirst()));
                }
                operators.offerFirst(c);
            }
        }
        
        while (!operators.isEmpty()) {
            number = cal(numbers.pollFirst(), number, operators.pollFirst());
        }
        return number;
    }

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

    private int priority(char c) {
        if (c == '+' || c == '-') {
            return 0;
        }
        return 1;
    }
}