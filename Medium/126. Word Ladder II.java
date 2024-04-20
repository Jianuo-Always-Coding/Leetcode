class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        List<String> layer = new ArrayList<>();
        Map<String, List<List<String>>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        queue.offer(beginWord);
        List<String> ini = new ArrayList<>();
        ini.add(beginWord);
        map.put(beginWord, new ArrayList<List<String>>());
        map.get(beginWord).add(ini);
        boolean 

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<String> layerVisit = new ArrayList<>(); // 在这一层新visit的点

            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                // 是最后
                if (word.equals(endWord)) {
                    return map.get(endWord);
                }

                char[] array = word.toCharArray();

                for (int j = 0; j < array.length; j++) {
                    char temp = array[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        array[j] = c;
                        String newWord = new String(array);
                        if (!visited.contains(newWord) && set.contains(newWord)) {
                            layerVisit.add(newWord);
                            List<List<String>> newPath = new ArrayList<>();
                            map.put(newWord, newPath);
                            for (List<String> list : map.get(word)) {
                                newPath.add(new ArrayList<>(list));
                                List<List<String>> subList = map.get(newWord);
                                for (List<String> li : subList) {
                                    li.add(newWord);
                                }
                            }
                            queue.offer(newWord);
                        }
                    }
                    array[j] = temp;
                }

                for (String s : layerVisit) {
                    visited.add(s);
                }
            }
        }
        return new ArrayList<List<String>>();
    }
}