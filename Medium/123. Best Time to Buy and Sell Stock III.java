class Solution {
    public int maxProfit(int[] prices) {
        // corner case
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int min = prices[0];
        int[] dp1 = new int[prices.length];
        int[] dp2 = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            dp1[i] = Math.max(dp1[i - 1], prices[i] - min);
        }
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            if (max < prices[i]) {
                max = prices[i];
            }
            dp2[i] = Math.max(dp2[i + 1], max - prices[i]);
        }

        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            result = Math.max(result, dp1[i] + dp2[i]);
        }
        return result;
    }
}