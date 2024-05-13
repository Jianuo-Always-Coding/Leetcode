class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] arr = s.toCharArray();

        Deque<Integer> stack = new ArrayDeque<>(); // 存放所有左括号的index

        for(int i = 0 ; i<arr.length; i++) {
            // 是左括号放入
            if(arr[i] == '(') {
                stack.offerFirst(i);
                continue;
            }
            // 是有括号
            if(arr[i] == ')') {
                // 没有左括号，移除
                if(stack.isEmpty()) {
                    arr[i] = ' ';
                // 有左括号，弹栈
                } else {
                    stack.pollFirst();
                }
            }
        }

        while(!stack.isEmpty()) {
            int index = stack.pollFirst();
            arr[index] = ' ';
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<arr.length; i++) {
            if(arr[i] != ' ') {
                sb.append(arr[i]);
            }
        }

        return sb.toString();
    }
}
