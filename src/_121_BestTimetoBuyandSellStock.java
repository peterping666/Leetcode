public class _121_BestTimetoBuyandSellStock {
    class Solution1 {
        public int maxProfit(int[] prices) {
            int profit = 0;
            int cost = Integer.MAX_VALUE;
            for(int price : prices) {
                cost = Math.min(cost, price); // buy
                profit = Math.max(profit, price - cost); // sell
            }
            return profit;
        }
    }

    class Solution2 {
        public int maxProfit(int[] prices) {
            int maxCur = 0, maxSoFar = 0;
            for(int i = 1; i < prices.length; i++) {
                maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
                maxSoFar = Math.max(maxCur, maxSoFar);
            }
            return maxSoFar;
        }
    }
}
