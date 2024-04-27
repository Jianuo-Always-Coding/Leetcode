class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>(); // 在第一个string里的字母和第二个里面的哪个匹配
        Map<Character, Character> map2 = new HashMap<>(); // 在第二个string里的字母和第一个里面的哪个匹配
        // 长度不等于，错
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++ ) {
            // 都包含
            if (map.containsKey(s.charAt(i)) && map2.containsKey(t.charAt(i))) {
                // 不匹配
                if (map.get(s.charAt(i)) != t.charAt(i) && map2.get(t.charAt(i)) != s.charAt(i)) {
                    return false;
                }
            // 有一个不包含
            } else if (map.containsKey(s.charAt(i)) || map2.containsKey(t.charAt(i))) {
                return false;
            // 放入
            } else {
                map2.put(t.charAt(i), s.charAt(i));
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}