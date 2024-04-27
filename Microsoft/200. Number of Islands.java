class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0; // 记录岛屿的数量

        // 遍历每一个岛
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    visited[i][j] = true;

                    // 用queue记录周围的岛屿
                    Queue<int[]> q = new ArrayDeque<>();
                    q.offer(new int[] {i, j});
                    while (!q.isEmpty()) {
                        int[] pos = q.poll();
                        int r = pos[0];
                        int c = pos[1];
                        if (r > 0 && !visited[r - 1][c] && grid[r-1][c] == '1') {
                            q.offer(new int[] {r - 1, c});
                            visited[r-1][c] = true;
                        }
                        if (r < grid.length - 1 && !visited[r + 1][c] && grid[r+1][c] == '1') {
                            q.offer(new int[] {r + 1, c});
                            visited[r+1][c] = true;
                        }
                        if (c > 0 && !visited[r][c - 1] && grid[r][c - 1] == '1') {
                            q.offer(new int[] {r , c-1});
                            visited[r][c-1] = true;
                        }
                        if (c < grid[0].length - 1 && !visited[r][c + 1] && grid[r][c + 1] == '1') {
                            q.offer(new int[] {r , c+1});
                            visited[r][c+1] = true;
                        }
                    }
                }
            }
        }
        return count;
    }
}


// 简化
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) continue;
            if (grid[nx][ny] == '1') {
                dfs(grid, nx, ny);
            }
        }
    }
}