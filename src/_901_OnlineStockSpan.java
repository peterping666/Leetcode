import java.util.ArrayDeque;
import java.util.Deque;

public class _901_OnlineStockSpan {
    class StockSpanner {

        Deque<int[]> stack;

        public StockSpanner() {
            stack = new ArrayDeque<>();
        }

        public int next(int price) {
            int[] cur = new int[]{price, 1};
            while(!stack.isEmpty() && stack.peek()[0] <= price) {
                cur[1] += stack.pop()[1];
            }
            stack.push(cur);
            return cur[1];
        }
    }
}
