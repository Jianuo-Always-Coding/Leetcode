class Solution {
    public int climbStairs(int n) {
        // corner case
        if (n <= 2) {
            return n;
        }

        int prev2 = 1;
        int prev1 = 2;
        int cur = 3;
        while (cur <= n) {
            int temp = prev1;
            prev1 += prev2;
            prev2 = temp;
            cur++;
        }
        return prev1;
    }
}