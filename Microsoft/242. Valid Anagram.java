class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }

        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i<s.length(); i++) {
            Integer count = map.getOrDefault(t.charAt(i), 0); // 有的话拿出值，没有的话为0
            if (count == 0) {
                return false;
            }
            map.put(t.charAt(i), count - 1);
        }
        return true;
    }
}