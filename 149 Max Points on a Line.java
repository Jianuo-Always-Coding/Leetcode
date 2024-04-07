class Solution {
    public int maxPoints(int[][] points) {
        // corner case 
        if (points.length == 1) {
            return 1;
        }
        int max = 2;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                max = Math.max(max, find(i, j, points));
            }
        }
        return max;
    }

    private int find(int i, int j, int[][] points) {
        int[] p1 = points[i];
        int[] p2 = points[j];
        int count = 0;
        for (int k = 0; k < points.length; k++) {
            int[] p3 = points[k];
            if (k == i || k == j || (p1[0] - p2[0]) * (p2[1] - p3[1]) == (p2[0] - p3[0]) * (p1[1] - p2[1])) {
                count++;
            }
        }
        return count;
    }
}