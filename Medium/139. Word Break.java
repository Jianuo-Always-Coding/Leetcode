class Solution {
    public boolean wordBreak(String input, List<String> dict) {
        // corner case
        Set<String> set = new HashSet<>();
        for (String s : dict) {
            set.add(s);
        }

        boolean[] wordsComposed = new boolean[input.length() + 1]; // index 0 is true
        wordsComposed[0] = true; // i 表示包含几个字符

        for (int i = 1; i <= input.length(); i++) { // i is the total length of the string
            for (int j = 0; j < i; j++) { // j表示已经看过几个字符了
                if (wordsComposed[j] && set.contains(input.substring(j, i))) {
                    wordsComposed[i] = true;
                    continue;
                }
            }
        }
        return wordsComposed[wordsComposed.length - 1];
    }
}