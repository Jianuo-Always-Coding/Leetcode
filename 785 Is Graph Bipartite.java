class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<int[]> q = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < graph.length; i++) {
            // 如果map中不存在说明是新点，随便给他一个flag
            if (map.containsKey(i)) {
                    continue;
            // 如果map中存在，说明一定可以成功，跳过
            } else {
                map.put(i, 0);
                q.offer(new int[] {i, 0});
            }

            // 遍历所有neibours，记住只有新点可以加入queue，旧点只需要比较
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int id = cur[0];
                int flag = cur[1];
                int neiFlag = (flag == 0 ? 1 : 0);

                for (int j = 0; j < graph[id].length; j++) {
                    if (!map.containsKey(graph[id][j])) {
                        map.put(graph[id][j], neiFlag);
                        q.offer(new int[] {graph[id][j], neiFlag});
                    } else if (map.get(graph[id][j]) != neiFlag) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}