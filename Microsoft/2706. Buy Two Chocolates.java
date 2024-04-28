class Solution {
    public int buyChoco(int[] prices, int money) {
        int index = 0;
        // corner case
        if (prices == null || prices.length <= 1) {
            return money;
        }
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < prices[index]) {
                index = i;
            }
        }
        int minVal1 = prices[index];
        prices[index] = Integer.MAX_VALUE;

        if (minVal1 > money) {
            return money;
        }

        index = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < prices[index]) {
                index = i;
            }
        }
        int minVal2 = prices[index];
        int restMoney = money - minVal1 - minVal2;
        if (restMoney >= 0) {
            return restMoney;
        }
        return money;
        


    }
}