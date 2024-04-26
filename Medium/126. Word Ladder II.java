class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList); // 存储可以遍历的路径
        Set<String> visited = new HashSet<>(); // 存储之前便利过的点
        Queue<String> queue = new ArrayDeque<>(); //存储接下来可以到达的点
        Map<String, List<List<String>>> map = new HashMap<>(); //记录所有到达当前点的最短路径
        List<List<String>> result = new ArrayList<>(); // 存储返回的结果

        queue.offer(beginWord); // 把起点放进去
        List<String> ini = new ArrayList<>(); 
        ini.add(beginWord);
        map.put(beginWord, new HashSet<List<String>>()); // 把到达起点的路径放进去
        map.get(beginWord).add(ini);

        // 使用BFS遍历每一层
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<String> layerVisit = new ArrayList<>(); // 在这一层新visit的点, 用set也可以

            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                // 是最后
                if (word.equals(endWord)) {
                    return map.get(endWord);
                }

                char[] array = word.toCharArray();
                // 使用DFS寻找可能到达的点
                for (int j = 0; j < array.length; j++) {
                    char temp = array[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        array[j] = c;
                        //没变
                        if (c == temp) {
                            continue;
                        }
                        String newWord = new String(array);
                        if (!visited.contains(newWord) && set.contains(newWord)) {
                            if (!map.containsKey(newWord)) {
                                layerVisit.add(newWord);
                                List<List<String>> newPath = new ArrayList<>();
                                map.put(newWord, newPath);
                            }

                            List<List<String>> prevPath = new ArrayList<>(map.get(word));

                            for (List<String> path : prevPath) {
                                List<String> newPath = new ArrayList<>(path);
                                newPath.add(newWord);

                                if (!map.containsKey(newWord)) {
                                    layerVisit.add(newWord);
                                    map.put(newWord, new ArrayList<>());
                                }

                                map.get(newWord).add(newPath);
                            }
                            queue.offer(newWord);
                        }
                    }
                    array[j] = temp;
                }

            }

            for (String s : layerVisit) {
                visited.add(s);
            }
        }
        return new ArrayList<List<String>>();
    }
}