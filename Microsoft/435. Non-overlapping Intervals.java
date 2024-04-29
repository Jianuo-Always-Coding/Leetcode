class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]); // 根据起始位置对二维数组进行排序
        int lastEnd = Integer.MIN_VALUE; // 记录结束的位置
        int count = 0; // 记录需要移除的区间的数量
        for(int[] interval: intervals){
            if(interval[0] < lastEnd){
                // 移除
                count++;
                lastEnd = Math.min(lastEnd, interval[1]);
            }else{
                // 移动结束时间
                lastEnd = interval[1];
            }
        }
        return count;   
    }
}