class Solution {
    public int maxProfit(int[] prices) {
        // corner case
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int min = prices[0];
        int money = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                money = Math.max(money, prices[i] - min);
            } else {
                min = Math.min(min, prices[i]);
            }
        }
        return money;
    }
}