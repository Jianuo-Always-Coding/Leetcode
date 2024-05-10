class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // BFS实现,
        // 需要check：start在不在list中，end在不在List中
        Set<String> set = new HashSet<>(wordList); // 存放所有路径，
        Queue<String> queue = new ArrayDeque<>();  // 下一个能走的点

        queue.offer(beginWord); // 起始点放入
        visited.add(beginWord);
        int count = 0; // 步数为 0


        while (!queue.isEmpty()) {
            int size = queue.size();  // 记录当前层有多少元素
            count++; // 走一步，路径加一
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                // 找到了
                if (word.equals(endWord)) {
                    return count;
                }

                char[] array = word.toCharArray();
                for (int j = 0; j < array.length; j++) {
                    char temp = array[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        array[j] = c;
                        String newWord = new String(array);
                        // 注意，一旦到达这个点，表示无法在以后的路径中到达，所以需要移除
                        if (set.contains(newWord)) {
                            set.remove(newWord);
                            queue.offer(newWord);
                        }
                    }
                    // 恢复字符
                    array[j] = temp;
                }
            }
        }
        // 没找到
        return 0;
    }
}



