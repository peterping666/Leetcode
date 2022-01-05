public class _123_BestTimetoBuyandSellStockIII {
    class Solution1 {
        public int maxProfit(int[] prices) {
            int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE, sell1 = 0, sell2 = 0;
            for(int price : prices) {
                int oldBuy1 = buy1;
                int oldBuy2 = buy2;
                int oldSell1 = sell1;
                int oldSell2 = sell2;

                buy1 = Math.max(oldBuy1, -price);
                sell1 = Math.max(oldSell1, buy1 + price);
                buy2 = Math.max(oldBuy2, sell1 - price);
                sell2 = Math.max(oldSell2, buy2 + price);
            }

            return sell2;
        }
    }

    class Solution2 {
        public int maxProfit(int[] prices) {
            int buy1 = Integer.MAX_VALUE, buy2 = Integer.MAX_VALUE, sell1 = 0, sell2 = 0;
            for(int price : prices) {
                int oldBuy1 = buy1;
                int oldBuy2 = buy2;
                int oldSell1 = sell1;
                int oldSell2 = sell2;

                buy1 = Math.min(oldBuy1, price);
                sell1 = Math.max(oldSell1, price - buy1);
                buy2 = Math.min(oldBuy2, -sell1 + price);
                sell2 = Math.max(oldSell2, price - buy2);
            }

            return sell2;
        }
    }
}
