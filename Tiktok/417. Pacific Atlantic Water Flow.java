class Solution {
    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private int numRows;
    private int numCols;
    private int[][] heights;
    
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        // Check if input is empty
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        
        // Save initial values to parameters
        numRows = matrix.length;
        numCols = matrix[0].length;
        heights = matrix;

        // setup each queue with cells adjacent to their respextive ocean
        Queue<int []> pacificQ = new LinkedList<>();
        Queue<int []> atlanticQ = new LinkedList<>();

        
        // Loop through each cell adjacent to the oceans and start a DFS
        // 放入一列
        for (int i = 0; i < numRows; i++) {
            pacificQ.offer(new int[] {i, 0});
            atlanticQ.offer(new int[] {i, numCols - 1});
        }
        // 放入一行
        for (int i = 0; i < numCols; i++) {
            pacificQ.offer(new int[] {0, i});
            atlanticQ.offer(new int[] {numRows - 1, i});
        }


        // 能到达的地方
        boolean[][] pacificReachable = bfs(pacificQ);
        boolean[][] atlanticReachable = bfs(atlanticQ);
        
        // Find all cells that can reach both oceans
        List<List<Integer>> commonCells = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    commonCells.add(List.of(i, j));
                }
            }
        }
        return commonCells;
    }
    
    private boolean[][] bfs(Queue<int[]> queue) {
        // This cell is reachable, so mark it
        boolean[][] reachable = new boolean[numRows][numCols];
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            reachable[cell[0]][cell[1]] = true;
            for (int[] dir : DIRECTIONS) {
                int newR = cell[0] + dir[0];
                int newC = cell[1] + dir[1];
                // 不合法跳过
                if (newR < 0 || newR >= numRows || newC < 0 || newC >= numCols) {
                    continue;
                }
                
                // 访问过也跳过
                if (!reachable[newR][newC] && heights[newR][newC] >= heights[cell[0]][cell[1]]) {
                    queue.offer(new int[] {newR, newC});
                }
            }
        }
        return reachable;
    }
}
