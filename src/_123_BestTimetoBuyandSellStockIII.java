public class _123_BestTimetoBuyandSellStockIII {
    /**
     * t1_cost: the minimal cost of buying the stock in transaction #1.
     * The minimal cost to acquire a stock would be the minimal price value that we have seen so far at each step.
     *
     * t1_profit: the maximal profit of selling the stock in transaction #1. Actually,
     * at the end of the iteration, this value would be the answer for the first problem in the series,
     * i.e. Best Time to Buy and Sell Stock.
     *
     * t2_cost: the minimal cost of buying the stock in transaction #2,
     * while taking into account the profit gained from the previous transaction #1.
     * One can consider this as the cost of reinvestment. Similar with t1_cost,
     * we try to find the lowest price so far,
     * which in addition would be partially compensated by the profits gained from the first transaction.
     *
     * t2_profit: the maximal profit of selling the stock in transaction #2.
     * With the help of t2_cost as we prepared so far,
     * we would find out the maximal profits with at most two transactions at each step.
     */

    class Solution1 {
        public int maxProfit(int[] prices) {
            int buy1 = Integer.MAX_VALUE;
            int buy2 = Integer.MAX_VALUE;
            int sell1 = 0;
            int sell2 = 0;
            for (int i = 0; i < prices.length; i++) {
                buy1 = Math.min(buy1, prices[i]);
                sell1 = Math.max(sell1, prices[i] - buy1);
                buy2 = Math.min(buy2, prices[i] - sell1);
                sell2 = Math.max(sell2, prices[i] - buy2);
            }
            return sell2;
        }
    }

    class Solution2 {
        public int maxProfit(int[] prices) {
            int t1Cost = Integer.MAX_VALUE;
            int t2Cost = Integer.MAX_VALUE;
            int t1Profit = 0;
            int t2Profit = 0;
            for (int price : prices) {
                // the maximum profit if only one transaction is allowed
                t1Cost = Math.min(t1Cost, price);
                t1Profit = Math.max(t1Profit, price - t1Cost);
                // reinvest the gained profit in the second transaction
                t2Cost = Math.min(t2Cost, price - t1Profit);
                t2Profit = Math.max(t2Profit, price - t2Cost);
            }
            return t2Profit;
        }
    }
}
