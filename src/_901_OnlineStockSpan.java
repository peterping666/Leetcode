import java.util.ArrayDeque;
import java.util.Deque;

public class _901_OnlineStockSpan {
    class StockSpanner {
        private Deque<int[]> stack;
        public StockSpanner() {
            stack = new ArrayDeque<>();
        }

        public int next(int price) {
            int res = 1;
            while (!stack.isEmpty() && stack.peekFirst()[0] <= price)
                res += stack.pollFirst()[1];
            stack.offerFirst(new int[]{price, res});
            return res;
        }
    }
}
