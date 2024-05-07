class Solution {
    public double myPow(double x, int n) {
        // corner case
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return myPow(1.0 / x, (n + 1) * (-1)) * (1.0 / x);
            }
            return myPow(1.0 / x, n * (-1));
        }
        double halfPow = myPow(x, n / 2);
        if (n % 2 == 0) {
            return halfPow * halfPow;
        } 
        return halfPow * halfPow * x;
    }
}
