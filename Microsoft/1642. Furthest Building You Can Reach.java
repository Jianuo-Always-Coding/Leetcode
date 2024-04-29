class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // 初始化一个最小堆，用于存储相邻建筑的高度差
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 遍历建筑高度数组
        for (int i = 1; i < heights.length; i++) {
            // 计算当前建筑与前一个建筑的高度差
            int diff = heights[i] - heights[i - 1];
            // 如果高度差大于0，表示下一座建筑比当前建筑更高
            if (diff > 0) {
                // 将高度差加入最小堆
                pq.add(diff);
                // 如果最小堆的大小超过了梯子的数量
                // 希望梯子用在较大间隔，小的用bricks
                if (pq.size() > ladders) {
                    // 使用砖块来搭建梯子，减去最小堆中的最小高度差所需的砖块数量
                    bricks -= pq.poll();
                    // 如果砖块数量不足以继续搭建梯子，则返回当前建筑的前一个建筑
                    if (bricks < 0) {
                        return i - 1;
                    }
                }
            }
        }
        // 如果遍历完所有建筑都能够到达，则返回最后一个建筑的索引
        return heights.length - 1;
    }
}