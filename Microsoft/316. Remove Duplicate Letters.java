class Solution {
    public String removeDuplicateLetters(String s) {
        int[] nums = new int[26];
        boolean[] seen = new boolean[26];
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            nums[c - 'a']++; // track the lastIndex of character presence
        }
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - 'a';
            if (seen[cur]) {
                nums[cur]--; // 将这个字母减一
                continue;
            }
            // 前面有字母，字母比他大，并且这个字母在后面还出现过
            while (!stack.isEmpty() && stack.peekFirst() > cur && nums[stack.peekFirst()] > 0){
                seen[stack.pollFirst()] = false;
            }
            stack.offerFirst(cur); // add into stack
            seen[cur] = true;
            nums[cur]--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append((char) (stack.pollFirst()+ 'a'));
        return sb.reverse().toString();
    }
}