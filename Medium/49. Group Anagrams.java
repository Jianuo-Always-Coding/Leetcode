class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] list = new char[26];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                list[c - 'a']++;
            }

            String key = String.valueOf(list);
            // System.out.println(key);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }

        for (Map.Entry<String, List<String>> e : map.entrySet()) {
            List<String> list = e.getValue();
            result.add(list);
        }
        return result;

    }
}