import java.util.Arrays;

public class _188_BestTimetoBuyandSellStockIV {

    /**
     * Time O(nk)
     * Space O(k)
     */
    class Solution1 {
        public int maxProfit(int k, int[] prices) {
            if(prices.length == 0) {
                return 0;
            }
            int[] buy = new int[k + 1];
            int[] sell = new int[k + 1];
            Arrays.fill(buy, -prices[0]);
            for(int i = 1; i < prices.length; i++) {
                for(int j = 1; j <= k; j++) {
                    buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
                    sell[j] = Math.max(sell[j], prices[i] + buy[j]);
                }
            }
            return sell[k];
        }
    }

    /**
     * Time O(nk)
     * Space O(k)
     */
    class Solution2 {
        public int maxProfit(int k, int[] prices) {
            if(prices.length == 0) {
                return 0;
            }
            int[] costs = new int[k + 1];
            int[] profits = new int[k + 1];
            Arrays.fill(costs, prices[0]);
            for(int i = 1; i < prices.length; i++) {
                for(int j = 1; j <= k; j++) {
                    costs[j] = Math.min(costs[j], prices[i] - profits[j - 1]);
                    profits[j] = Math.max(profits[j], prices[i] - costs[j]);
                }
            }
            return profits[k];
        }
    }
}
