class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int radius = 0;

        for (int i = 0; i < houses.length; i++) {
            int bestSolution = Integer.MAX_VALUE;
            for (int j = 0; j < heaters.length; j++) {
                bestSolution = Math.min(Math.abs(houses[i] - heaters[j]), bestSolution);
            }
            radius = Math.max(radius, bestSolution);
        }
        return radius;
    }
}