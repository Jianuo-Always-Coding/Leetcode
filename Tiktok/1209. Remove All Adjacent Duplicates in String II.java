class Solution {
    // 构建一个新类，存储这个字符以及字符出现个数
    class Node {
        char ch;
        int count;
        public Node(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
    public String removeDuplicates(String s, int k) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Deque<Node> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            // 没字符或者不一样
            if (stack.isEmpty() || ch != stack.peek().ch) {
                stack.offerFirst(new Node(ch, 1));
            // 一样，更新数量
            } else {
                stack.peekFirst().count += 1;
            }
            //达到k就移除掉
            if (stack.peekFirst().count == k) {
                stack.pollFirst();
            }
        }

        // 整理结果
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            Node n = stack.pollFirst();
            char c = n.ch;
            int num = n.count;
            for (int i = 0; i < num; i++) {
                res.append(c);
            }
        }
        return res.reverse().toString();     
    }
}
