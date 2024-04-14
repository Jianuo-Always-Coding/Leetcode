class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);
        int total = area1 + area2;
        
        if (ax1 < bx2 && bx1 < ax2 && ay1 < by2 && by1 < ay2) {
            int yBottom = Math.max(ay1, by1);  // 0
            int yTop = Math.min(ay2, by2); // 2
            int xLeft = Math.max(ax1, bx1); // 0
            int xRight = Math.min(ax2, bx2);
            return total - (xRight - xLeft) * (yTop - yBottom);
        }
        return total;
    }
}
