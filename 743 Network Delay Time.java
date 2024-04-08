class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        // build priorityQueue<Node> 
        // build a boolean array visited
        // count record the number arrived
        class Node {
            int id;
            int timeNeed;

            public Node(int id, int timeNeed) {
                this.id = id;
                this.timeNeed = timeNeed;
            }
        }
        
        // build a map <senter, list of (reveiver,time)>
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] time : times) {
            int senter = time[0];
            if (map.get(senter) == null) {
                map.put(senter, new ArrayList<>());
            }
            map.get(senter).add(new int[]{time[1], time[2]});
        }

        // 每个node只能从heap中出来一次，出来的时候就是最优
        PriorityQueue<Node> minHeap = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                if (n1.timeNeed == n2.timeNeed) {
                    return 0;
                }
                return n1.timeNeed < n2.timeNeed ? -1 : 1;
            }
        });

        boolean[] visited = new boolean[n + 1];
        int count = 0;
        int minTime = 0;

        minHeap.offer(new Node(k, 0));

        while (count < n && !minHeap.isEmpty()) {
            Node cur = minHeap.poll();
            if (visited[cur.id]) {
                continue;
            }
            visited[cur.id] = true;
            count++;
            int timeTillNow = cur.timeNeed;
            minTime = Math.max(minTime, timeTillNow);
            if (!map.containsKey(cur.id)) {
                continue;
            }
            List<int[]> neis = map.get(cur.id);
            for (int[] nei : neis) {
                minHeap.offer(new Node(nei[0], timeTillNow + nei[1]));
            }
        }
        if (count == n) {
            return minTime;
        }
        return -1;

    }
}