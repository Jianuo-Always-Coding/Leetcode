class Solution {
    public int scoreOfParentheses(final String s) {
        // 只含有左右两个括号, 并且一定valid
        // 为什么用stack，因为需要得到最近的计算结果
        Deque<Integer> stack = new ArrayDeque<>(); // 存放暂时的计算结果
        int score = 0;

        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == '(') {
                // 把之前计算的结果放入stack中
                stack.offerFirst(score);
                score = 0;
            } else {
                score = stack.pollFirst() + (score == 0 ? 1 : 2 * score);
            }
        }

        return score;
    }
}
