
class Solution {
    public int fib(int n) {
        if(n == 0) return 0;
        int[] DP = new int[n + 1];
        // initialization 
        DP[0] = 0;
        DP[1] = 1;
        // recursion 
        for(int i = 2; i <= n; i++){
            DP[i] = DP[i-1] + DP[i-2];
        }
        return DP[n];
    }
}