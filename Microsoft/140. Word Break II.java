class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {

        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        DFS(s, wordDict, sb, 0, result);

        return res;
    }

    private void DFS (String s, List<String> wordDict, StringBuilder sb, int start, List<String> result) {
        if (start >= s.length()) {
            if (start == s.length()) {
                result.add(sb.toString().substring(0, sb.length() - 1));
            }
            return;
        }

        for (String word : wordDict) {
            if (start + word.length() <= s.length() && s.substring(start, start + word.length()).equals(word)) {
                sb.append(word);
                sb.append(" ");

                DFS(s, wordDict, sb, start + word.length(), res);

                sb.delete(sb.length() - word.length() - 1, sb.length());
            }
        }

    }

}