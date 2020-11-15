public class _121_BestTimetoBuyandSellStock {
    class Solution1 {
        public int maxProfit(int[] prices) {
            int minprice = Integer.MAX_VALUE;
            int maxprofit = 0;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < minprice)
                    minprice = prices[i];
                else if (prices[i] - minprice > maxprofit)
                    maxprofit = prices[i] - minprice;
            }
            return maxprofit;
        }
    }
    class Solution2 {
        public int maxProfit(int[] prices) {
            int maxCur = 0;
            int maxSoFar = 0;
            for(int i = 1; i < prices.length; i++) {
                maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
                maxSoFar = Math.max(maxCur, maxSoFar);
            }
            return maxSoFar;
        }
    }
}
