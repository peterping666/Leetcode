import java.util.ArrayDeque;
import java.util.Deque;

public class _1381_DesignaStackWithIncrementOperation {
    class CustomStack {
        private int n;
        private int[] inc;
        private Deque<Integer> stack;

        public CustomStack(int maxSize) {
            n = maxSize;
            inc = new int[n];
            stack = new ArrayDeque<>();
        }

        public void push(int x) {
            if (stack.size() < n) {
                stack.offerFirst(x);
            }
        }

        public int pop() {
            int i = stack.size() - 1;
            if (i < 0) {
                return -1;
            }
            if (i > 0) {
                inc[i - 1] += inc[i];
            }
            int res = stack.pollFirst() + inc[i];
            inc[i] = 0;
            return res;
        }

        public void increment(int k, int val) {
            int i = Math.min(k, stack.size()) - 1;
            if (i >= 0) {
                inc[i] += val;
            }
        }
    }
}
