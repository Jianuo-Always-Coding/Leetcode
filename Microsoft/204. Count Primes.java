class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1]; 
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i <= n; i++) {
            // 如果这个数是素数，那么他所有的倍数都不是
            // 可以加上这个条件来进行优化
            // if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                // }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }
}