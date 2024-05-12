class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // 滚球模型
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // right, down, left, up
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == destination[0] && cur[1] == destination[1]) {
                return true;
            }

            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                // 沿着当前方向一直走到不能走为止
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                }
                // 回退到最后有效的位置
                x -= dir[0];
                y -= dir[1];
                if (!visited[x][y]) {
                    visited[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
        }

        return false;
    }
}
