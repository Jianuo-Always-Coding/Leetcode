class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || p.length() > s.length()) {
            return result;
        }
        if (p == null || p.length() == 0) {
            for (int i = 0; i < s.length(); i++) {
                result.add(i);
            }
            return result;
        }

        Map<Character, Integer> map = new HashMap<>();
        //把需要的字母和数量更新到map中
        putIntoMap(map, p);
        int needToMatch = map.size();
        int matchedNum = 0;

        // initialize the map
        for (int i = 0; i < p.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    matchedNum++;
                }
            }
        }

        // move the slide
        for (int i = 0; i < s.length() - p.length(); i++) {
            if (matchedNum == needToMatch) {
                result.add(i);
            }

            // move to next step; - remove(i) and add(i + sh.length())
            char start = s.charAt(i);
            if (map.containsKey(start)) {
                map.put(start, map.get(start) + 1);
                if (map.get(start) == 1) {
                    matchedNum--;
                }
            }

            char end = s.charAt(i + p.length());
            if (map.containsKey(end)) {
                map.put(end, map.get(end) - 1);
                if (map.get(end) == 0) {
                    matchedNum++;
                }
            }
        }

        // 判断最后一个
        if (matchedNum == needToMatch) {
            result.add(s.length() - p.length());
        }
        return result;

    }

    private void putIntoMap(Map<Character, Integer> map, String s) {
        // corner case
        if (s == null || s.length() == 0) {
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
    }
}