class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        char c = ' ';

        for (int i = 0 ; i < t.length(); i++) {
            c = t.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int matchedNeed = map.size();

        String result = "";
        int start = 0;
        int end = 0;

        while (start < s.length() && end < s.length()) {
            while (end < s.length() && matchedNeed > 0) {
                c = s.charAt(end++);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) - 1);
                    if (map.get(c) == 0) {
                        matchedNeed--;
                    }
                }
            }

            while (start < s.length() && matchedNeed == 0) {
                c = s.charAt(start++);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    if (map.get(c) == 1) {
                        if (result == "" || end - 1 - (start - 1) + 1 < result.length()) {
                            result = s.substring(start - 1, end);
                        } 
                        matchedNeed++;
                    }
                }
            }

        }
        return result;
    }
}