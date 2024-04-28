class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>(); // 维护一个单调递增的栈
        int maxArea = 0;
        
        for (int i = 0; i <= heights.length; i++) {
            int cur = (i == heights.length) ? 0 : heights[i]; // 放入最后一个0计算全部
            // 如果存在相邻相等，我们也认为他是增加的
            while (!stack.isEmpty() && cur < heights[stack.peekFirst()]) {
                int height = heights[stack.pollFirst()];
                // 1 6 7 4， 中间可能存在弹掉的，所以要看一下最左边的边界是多少
                // 弹出一个就可以计算当前高度的最大矩形是多少 
                int width = stack.isEmpty() ? i : i - stack.peekFirst() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.offerFirst(i);
        }
        
        return maxArea;
    }
}