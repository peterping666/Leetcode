public class _122_BestTimetoBuyandSellStockII {
    class Solution {
        public int maxProfit(int[] prices) {
        /*
            profit: maximum total profit.
            buy: the day when buy stock.
            sell: the day when sell stock.
            days: maximum trade days.
        */
            int profit = 0;
            int buy = 0;
            int sell = 0;
            int days = prices.length;

            while(buy < days && sell < days)
            {
                while(buy < days - 1 && prices[buy + 1] < prices[buy]) {
                    buy++; // find the valley of prices
                }
                sell = buy;
                while(sell < days - 1 && prices[sell + 1] > prices[sell]) {
                    sell++; // find the peak of prices
                }
                profit += prices[sell] - prices[buy];
                buy = sell + 1;
            }
            return profit;
        }
    }
}
