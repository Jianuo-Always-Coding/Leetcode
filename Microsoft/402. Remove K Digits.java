class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for(char n: num.toCharArray()){
            while(stack.size() > 0 && k > 0 && stack.peek() > n){
                stack.pop();
                k--;
            }
            stack.add(n);
        }
        while(k > 0){
            stack.pop();
            k--;
        }
        if (stack.isEmpty()) return "0";

        StringBuilder sb = new StringBuilder();
        for(char digit: stack){
            sb.append(digit);
        }
        while (sb.length() > 0 && sb.charAt(0) == '0') {
                sb.deleteCharAt(0);

        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
