class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> merge = new ArrayList<>();
        
        int n = intervals.length;
        int index = 0;
        // 结束在新interval开始之前，可以放心加
        while (index < n && intervals[index][1] < newInterval[0]) {
            merge.add(intervals[index]);
            index++;
        }
        // 一直加到最后，或者到newInterval结束时间 小于下一个interval开始时间结束
        while (index < n && intervals[index][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
            index++;
        }
        merge.add(newInterval);

        // 加入剩下的
        while (index < n) {
            merge.add(intervals[index]);
            index++;
        }
        return merge.toArray(new int[merge.size()][]);

    }
}
