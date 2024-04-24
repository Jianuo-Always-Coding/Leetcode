class Solution {
    public String alienOrder(String[] words) {
        // corner case
        if (words == null || words.length == 0) {
            return "";
        }

        Map<Character, Set<Character>> map = new HashMap<>(); 
        int[] degree = new int[26];
        for (int i = 0; i < 26; i++) {
            degree[i] = -1;
        }
        int count = 0;

        // 先找出所有的字母，然后将他们的入度设为0
        for (String word : words) {
            for (int i = 0 ; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!map.containsKey(c)) {
                    map.put(c, new HashSet<Character>());
                }
                if (degree[c - 'a'] == -1) {
                    degree[c - 'a'] = 0;
                    count++;
                }
            }
        }

        // 计算入度
        for (int i = 1; i < words.length; i++) {
            int a = 0;
            int b = 0;
            String word1 = words[i - 1];
            String word2 = words[i];
            if (word1.startsWith(word2) && word1.length() > word2.length()) {
                return "";
            }
            while (a < word1.length() && b < word2.length()) {
                if (word1.charAt(a) == word2.charAt(b)) {
                    a++;
                    b++;
                } else {
                    if (map.get(word1.charAt(a)).add(word2.charAt(b))) {
                        degree[word2.charAt(b) - 'a']++;
                    }
                    break;
                }
            }
        }

        Queue<Character> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            if (degree[i] == 0) {
                q.offer((char)(i + 'a'));
            }
        }

        while (!q.isEmpty()) {
            char c = q.poll();
            sb.append(c);
            for (Character ch : map.get(c)) {
                degree[ch - 'a']--;
                if (degree[ch - 'a'] == 0) {
                    q.offer(ch);
                }
            }
        }

        if (sb.length() == count) {
            return sb.toString();
        }
        return "";
        
    }
}
