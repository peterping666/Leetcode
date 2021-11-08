import java.util.LinkedList;
import java.util.Queue;

public class _225_ImplementStackusingQueues {
    class MyStack {

        /** Initialize your data structure here. */
        private Queue<Integer> q1;

        public MyStack() {
            q1 = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            q1.add(x);
            int sz = q1.size();
            while (sz > 1) {
                q1.add(q1.remove());
                sz--;
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return q1.remove();
        }

        /** Get the top element. */
        public int top() {
            return q1.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q1.isEmpty();
        }
    }
}
