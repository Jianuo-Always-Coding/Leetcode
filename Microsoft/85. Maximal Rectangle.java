class Solution {
    public int maximalRectangle(char[][] matrix) {
        // corner case
        if (matrix == null) {
            return 0;
        }
        // 把矩阵的每一行看成柱状图
        int[][] cols = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == '1') {
                cols[0][i] = 1;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    cols[i][j] = cols[i - 1][j] + 1;
                }
            }
        }
        // 把矩阵的每一行看成柱状图
        // 遍历每一行
        // 单调递减栈
        int max = 0;

        for (int j = 0; j < matrix.length; j++) {
            Deque<Integer> stack = new ArrayDeque<>();
            int maxArea = 0;
            for (int i = 0; i <= matrix[j].length; i++) {
                int cur = (i == matrix[j].length) ? 0 : cols[j][i]; // 放入最后一个0计算全部
                // 如果存在相邻相等，我们也认为他是增加的
                while (!stack.isEmpty() && cur < cols[j][stack.peekFirst()]) {
                    int height = cols[j][stack.pollFirst()];
                    // 1 6 7 4， 中间可能存在弹掉的，所以要看一下最左边的边界是多少
                    // 弹出一个就可以计算当前高度的最大矩形是多少
                    int width = stack.isEmpty() ? i : i - stack.peekFirst() - 1;
                    maxArea = Math.max(maxArea, height * width);
                }
                stack.offerFirst(i);
            }
            max = Math.max(max, maxArea);

        }
        return max;
    }
}