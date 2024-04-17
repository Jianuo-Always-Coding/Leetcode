class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return (double)1;
        }

        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return myPow(1.0 / x, (n + 1) * (-1)) * (1.0 / x);
            }
            return myPow(1.0 / x, n * (-1));
        }

        double half = myPow(x, n / 2);
        if (n % 2 == 1) {
            return half * half * x;
        } 
        return half * half;
    }
}