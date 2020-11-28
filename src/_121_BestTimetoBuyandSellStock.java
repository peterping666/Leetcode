public class _121_BestTimetoBuyandSellStock {
    class Solution {
        public int maxProfit(int[] prices) {
            int profit = 0;
            int cost = Integer.MAX_VALUE;
            for(int price : prices) {
                cost = Math.min(cost, price); // but
                profit = Math.max(profit, price - cost); // sell
            }
            return profit;
        }
    }
}
