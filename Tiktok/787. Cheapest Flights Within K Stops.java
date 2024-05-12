class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n]; 
        Arrays.fill(prices, Integer.MAX_VALUE); 
        prices[src] = 0; // 把起发地的价格设置为0
        for(int i=0; i<=k; i++) { // 遍历每一次航行
            int[] tPrices = prices.clone();
            for(int[] flight: flights) { // 对于每一个能飞的航班
                int s = flight[0], d = flight[1], p = flight[2];
                if(prices[s]==Integer.MAX_VALUE) continue; // 看一下这个地方能不能到达
                if(prices[s] + p < tPrices[d]) // 更新目标机场的钱数
                    tPrices[d] = prices[s] + p;
            }
            prices = tPrices;
        }
        return prices[dst]==Integer.MAX_VALUE?-1:prices[dst];
    }
}
