package Laicode;

import java.util.Deque;
import java.util.LinkedList;

public class _32_StackWithmin {
    public class Solution {
        Deque<Integer> stack;
        Deque<int[]> minStack;
        public Solution() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
        }

        public int pop() {
            if(stack.isEmpty()) {
                return -1;
            }
            if(minStack.peekFirst()[1] == stack.size()) {
                minStack.pollFirst();
            }
            return stack.pollFirst();
        }

        public void push(int element) {
            if(stack.isEmpty() || element < minStack.peekFirst()[0]) {
                minStack.offerFirst(new int[]{element, stack.size() + 1});
            }
            stack.offerFirst(element);
        }

        public int top() {
            return stack.isEmpty() ? -1 : stack.peekFirst();
        }

        public int min() {
            if(stack.isEmpty()) {
                return -1;
            }
            return minStack.peekFirst()[0];
        }
    }
}
