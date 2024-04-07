class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();

        // 如果不是】就加入sb中，如果是的话移除sb，加入stack，直到是【，
        // 计数然后加入string builder中
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ']') {
                sb.append(c);
                continue;
            }
            Deque<Character> stack = new ArrayDeque<>();
            // 统计前面字符串
            while (sb.charAt(sb.length() - 1) != '[') {
                char ch = sb.charAt(sb.length() - 1);
                sb.deleteCharAt(sb.length() - 1);
                stack.offerFirst(ch);
            }
            System.out.println(stack.toString());
            StringBuilder temp = new StringBuilder();
            while (!stack.isEmpty()) {
                temp.append(stack.pollFirst());
            }
            sb.deleteCharAt(sb.length() - 1);
            // 统计数字
            int factor = 1;
            int sum = 0;
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) >= '0' && sb.charAt(sb.length() - 1) <= '9') {

                char ch = sb.charAt(sb.length() - 1);
                sb.deleteCharAt(sb.length() - 1);
                sum = sum + factor * (ch - '0');
                factor = factor * 10;
            }
            for (int j = 0; j < sum; j++) {
                sb.append(temp);
            }
        }
        return sb.toString();
    }
}