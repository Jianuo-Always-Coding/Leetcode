class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        Map<Integer, List<Integer>> map = new HashMap<>(); // 存放这个人和他不喜欢的人

        // 初始化map
        for (int[] pair : dislikes) {
            if (!map.containsKey(pair[0])) {
                map.put(pair[0], new ArrayList<Integer>());
            }
            if (!map.containsKey(pair[1])) {
                map.put(pair[1], new ArrayList<Integer>());
            }

            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }

        // 使用bfs
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < N; i++) {
            // 之前见过了，一定可以
            if (seen.containsKey(i)) {
                continue;
            }

            // 没见过
            seen.put(i, 0);
            queue.offer(i);
            
            while (!queue.isEmpty()) {
                int e = queue.poll();
                int label = seen.get(e);
                int neiLabel = (label == 0 ? 1 : 0);
                // 如果他没有不喜欢的人
                if (!map.containsKey(e)) {
                    break;
                }

                // 遍历他不喜欢的人
                for (Integer nei : map.get(e)) {
                    if (!seen.containsKey(nei)) {
                        seen.put(nei, neiLabel);
                        queue.offer(nei);
                    } else if (seen.get(nei) != neiLabel) {
                        return false;
                    }
                }

            }

        }

        return true;
    }

}
