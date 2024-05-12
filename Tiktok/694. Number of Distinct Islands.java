class Solution {
    int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>(); // 存储岛屿的编码格式

        // 遍历每一座独立的岛
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 是岛屿并且没访问过
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    // 求出岛屿的编码格式
                    helper(grid, i, j, i, j, sb); // ijij分别是开始位置的坐标和当前点的坐标
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }

    private void helper(int[][] grid, int i0, int j0, int i, int j, StringBuilder sb) {
        grid[i][j] = 0; // 将这个点抹掉
        sb.append((i - i0) + "" + (j - j0)); // 独特的编码格式
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
                continue;
            }
            helper(grid, i0, j0, x, y, sb);
        }
        
    }
}
