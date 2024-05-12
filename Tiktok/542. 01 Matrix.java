class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] res = new int[m][n];
        for (int[] row : res) {
            Arrays.fill(row, -1);
        }
        // 放入为0的起始位置    
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    res[i][j] = 0;
                }
            }
        }

        // BFS
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            for (int[] dir : dirs) {
                int nextX = dir[0] + x;
                int nextY = dir[1] + y;
                if (nextX < m && nextX >= 0 && nextY >= 0 && nextY < n 
                    && res[nextX][nextY] == -1) {
                        queue.offer(new int[] {nextX, nextY});
                        res[nextX][nextY] = res[x][y] + 1;// 第一次遇到一定是最近的
                    }
            }
        }

        return res;
    }
}
