class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>(); // 记录需要访问的点的row和col
        int count_fresh = 0;
        //Put the position of all rotten oranges in queue
        //count the number of fresh oranges
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols ; j++) {
                // 把所有的坏橘子放入queue中
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i , j});
                // 记录新鲜橘子的数量
                } else if(grid[i][j] == 1) {
                    count_fresh++;
                }
            }
        }
        //if count of fresh oranges is zero --> return 0 
        if(count_fresh == 0) return 0;
        int count = 0; // 记录需要的个数
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        // 使用bfs
        while(!queue.isEmpty()) {
            ++count;
            int size = queue.size();
            for(int i = 0 ; i < size ; i++) {
                int[] point = queue.poll();
                for(int dir[] : dirs) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];
                    // 如超界或者不是新鲜橘子，跳过
                    if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] != 1) continue;
                    //mark the orange at (x , y) as rotten
                    grid[x][y] = 2; // 把橘子转成坏橘子
                    queue.offer(new int[]{x , y}); // 放入队列
                    count_fresh--; // 新鲜橘子-1
                }
            }
        }
        return count_fresh == 0 ? count-1 : -1;
    }
}
