public class _309_BestTimetoBuyandSellStockwithCooldown {
    class Solution {
        public int maxProfit(int[] prices) {
            int buy = Integer.MIN_VALUE, sell = 0, cooldown = 0;
            for(int price : prices) {
                int oldBuy = buy, oldSell = sell, oldCooldown = cooldown;
                buy = Math.max(oldBuy, oldCooldown - price);
                sell = oldBuy + price;
                cooldown = Math.max(oldCooldown, oldSell);
            }
            return Math.max(sell, cooldown);
        }
    }
}
