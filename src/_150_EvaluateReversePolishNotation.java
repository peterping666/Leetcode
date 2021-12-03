import java.util.ArrayDeque;
import java.util.Deque;

public class _150_EvaluateReversePolishNotation {
    /**
     * Time O(n)
     * Space O(n)
     */
    class Solution {
        public int evalRPN(String[] tokens) {
            Deque<Integer> stack = new ArrayDeque<>();
            for(String token : tokens) {
                if(token.equals("+")) {
                    stack.push(stack.pop() + stack.pop());
                } else if(token.equals("-")) {
                    stack.push(-stack.pop() + stack.pop());
                } else if(token.equals("*")) {
                    stack.push(stack.pop() * stack.pop());
                } else if(token.equals("/")) {
                    int num2 = stack.pop();
                    stack.push(stack.pop() / num2);
                } else {
                    stack.push(Integer.valueOf(token));
                }
            }
            return stack.peek();
        }
    }
}
