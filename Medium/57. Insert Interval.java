class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> merge = new ArrayList<>();
        
        int n = intervals.length;
        int index = 0;

        while (index < n && intervals[index][1] < newInterval[0]) {
            merge.add(intervals[index]);
            index++;
        }

        while (index < n && intervals[index][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
            index++;
        }
        merge.add(newInterval);
        while (index < n) {
            merge.add(intervals[index]);
            index++;
        }
        return merge.toArray(new int[merge.size()][]);

    }
}