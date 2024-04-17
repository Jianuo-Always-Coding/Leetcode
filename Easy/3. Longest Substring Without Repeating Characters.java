class Solution {
    public int lengthOfLongestSubstring(String s) {
        // corner case
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int start = 0; // index of first including character
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
            } else {
                set.remove(s.charAt(start++));
                i--;
            }
            result = Math.max(result, i - start + 1);
        }
        return result;
    }
}