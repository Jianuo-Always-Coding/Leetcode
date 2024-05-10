class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts); // 所有会议的开始时间
        Arrays.sort(ends); // 所有会议的结束时间
        int rooms = 0;
        int endPoint = 0;
        for(int i=0; i<starts.length; i++) {
            if(starts[i] < ends[endPoint]) 
                // 会议没结束但是有新会议，增加一个room
                // 因为增加了room，所以结束时间不用动
                rooms++;
            else
                //没有冲突，结束时间需要增加
                endPoint++;
        }
        return rooms;
    }
}
