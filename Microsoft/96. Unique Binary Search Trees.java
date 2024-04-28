class Solution {
    public int numTrees(int n){
        int[] dp = new int[n+1];
        dp[0] = 1; // base case， 0个点只有1种可能
        for(int i = 1; i<=n; i++){ // 考虑一共有i个node
            for(int j =1; j<=i; j++){ // 左子树有j - 1个node
                // 右子树中有i - j个node
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}