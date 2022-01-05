public class _121_BestTimetoBuyandSellStock {
    class Solution {
        public int maxProfit(int[] prices) {
            int res = 0, min = Integer.MAX_VALUE;
            for(int price : prices) {
                if(price < min) {
                    min = price;
                } else {
                    res = Math.max(res, price - min);
                }
            }
            return res;
        }
    }
}
