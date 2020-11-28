import java.util.ArrayDeque;
import java.util.Deque;

public class _155_MinStack {
    class MinStack1 {
        private Deque<int[]> stack;

        public MinStack1() {
            stack = new ArrayDeque<>();
        }

        public void push(int x) {
            if(stack.isEmpty()) {
                stack.offerFirst(new int[]{x, x});
            } else {
                stack.offerFirst(new int[]{x, Math.min(x, stack.peekFirst()[1])});
            }
        }

        public void pop() {
            stack.pollFirst();
        }

        public int top() {
            return stack.peekFirst()[0];
        }

        public int getMin() {
            return stack.peekFirst()[1];
        }
    }

    class MinStack2 {
        private Deque<Integer> valStack;
        private Deque<Integer> minStack;

        public MinStack2() {
            valStack = new ArrayDeque<>();
            minStack = new ArrayDeque<>();
        }

        public void push(int x) {
            valStack.offerFirst(x);
            if(minStack.isEmpty() || minStack.peekFirst() >= x) {
                minStack.offerFirst(x);
            }

        }

        public void pop() {
            if(minStack.peekFirst().equals(valStack.pollFirst())) {
                minStack.pollFirst();
            }
        }

        public int top() {
            return valStack.peekFirst();
        }

        public int getMin() {
            return minStack.peekFirst();
        }
    }
}
