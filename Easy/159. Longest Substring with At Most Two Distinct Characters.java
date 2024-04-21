class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // corner case
        if (s == null) {
            return 0;
        }
        if (s.length() <= 2) {
            return s.length();
        }

        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        int end = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
                end++;
                // update length
                max = Math.max(max, end - start);

            } else if (map.size() == 2) {
                char pre = s.charAt(start);
                if ( map.get(pre) == 1 ) {
                    map.remove(pre);
                } else {
                    map.put(pre, map.get(pre) - 1);
                }
                start++;

            } else {
                map.put(c, 1);
                end++;
                max = Math.max(max, end - start);

            }
        }
        return max;
    }
}