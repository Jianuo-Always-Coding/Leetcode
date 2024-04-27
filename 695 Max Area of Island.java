class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(grid, i, j));
                }

            }
        }
        return res;
    }

    private int dfs(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1) {
            return 0;
        }
        grid[x][y] = 0;
        return 1 + dfs(grid, x + 1, y) + dfs(grid, x - 1, y) + dfs(grid, x, y - 1) + dfs(grid, x, y + 1);
    }
}