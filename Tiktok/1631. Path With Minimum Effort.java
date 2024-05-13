class Solution {
    private static final int[][] dir = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] dist = new int[m][n]; // 爬到dist中需要的最少的effort
        for(int i = 0; i < m; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[] {0, 0, 0}); // 起始点和到达这个点需要的最少的effort
        while(!pq.isEmpty()) {
            int[] p = pq.poll();
            int i = p[0], j = p[1];
            if(i == m - 1 && j == n - 1) break; // 到达终点
            for(int[] d: dir) {
                int x = i + d[0], y = j + d[1];
                if(x < 0 || x >= m || y < 0 || y >= n) continue; // 不合法
                int alt = Math.max(p[2], Math.abs(heights[i][j] - heights[x][y]));
                if(alt < dist[x][y]) {
                    dist[x][y] = alt;
                    pq.add(new int[] {x, y, alt});
                }
            }
        }
        return dist[m - 1][n - 1];
    }
}
