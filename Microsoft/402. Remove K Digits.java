class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>(); // 维护一个递增栈
        for(char n: num.toCharArray()){
            // 栈不为空，栈顶元素大于当前，还能弹
            while(!stack.isEmpty() && k > 0 && stack.peekFirst() > n){
                stack.poll First();
                k--;
            }
            stack.add(n);
        }
        // 还能移除，从大的开始移除
        while(k > 0){
            stack.pollFirst();
            k--;
        }
        // 移空了
        if (stack.isEmpty()) return "0";

        StringBuilder sb = new StringBuilder();
        for(char digit: stack){
            sb.append(digit);
        }
        // 移除0
        while (sb.length() > 0 && sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
        }
        // 移没了
        return sb.length() == 0 ? "0" : sb.toString();
    }
}