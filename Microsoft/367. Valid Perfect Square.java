class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2)
            return true; // Base case: 0 and 1 are perfect squares

        long left = 1; // Start from 1
        long right = num / 2; // Maximum possible square root

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;

            if (square == num) {
                return true; // Found the perfect square
            } else if (square < num) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        return false; // No perfect square found
    }
}