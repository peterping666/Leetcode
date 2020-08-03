import java.util.ArrayDeque;
import java.util.Deque;

public class _901_OnlineStockSpan {
    class StockSpanner {

        Deque<int[]> stack;
        int count;
        public StockSpanner() {
            stack = new ArrayDeque<>();
            count = 0;
            stack.offerFirst(new int[]{0,-1});
        }

        public int next(int price) {
            while(stack.peekFirst()[1] != -1 && stack.peekFirst()[0] <= price) {
                stack.pollFirst();
            }
            int res = count - stack.peekFirst()[1];
            stack.offerFirst(new int[]{price, count++});
            return res;
        }
    }

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
}
