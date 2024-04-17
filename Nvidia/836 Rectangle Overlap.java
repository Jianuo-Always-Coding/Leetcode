class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int r1x1 = rec1[0]; 
        int r1y1 = rec1[1];
        int r1x2 = rec1[2];
        int r1y2 = rec1[3];

        int rec2x1 = rec2[0]; 
        int rec2y1 = rec2[1];
        int rec2x2 = rec2[2];
        int rec2y2 = rec2[3];

        // 对于任意的长方形，最小的x一定小于另一个长方形中最大的，最大的x一定大于第二个中最小的
        // 对于y也同理

        if(r2x1 < r1x2 && r2y1 < r1y2 && r2x2 > r1x1 && r2y2 > r1y1) return true;
        return false;
    }
}


