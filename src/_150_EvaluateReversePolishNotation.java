import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

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
                    stack.offerFirst(stack.pollFirst() + stack.pollFirst());
                } else if(token.equals("-")) {
                    stack.offerFirst( -stack.pollFirst() + stack.pollFirst());
                } else if(token.equals("*")) {
                    stack.offerFirst( stack.pollFirst() * stack.pollFirst());
                } else if(token.equals("/")) {
                    int second = stack.pollFirst();
                    stack.offerFirst( stack.pollFirst() / second);
                } else{
                    stack.offerFirst(Integer.parseInt(token));
                }
            }
            return stack.peekFirst();
        }
    }

    /**
     * @param tokens
     * @return
     */
    public int evalRPN2(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (!"+-*/".contains(token)) {
                stack.push(Integer.valueOf(token));
                continue;
            }
            int number2 = stack.pop();
            int number1 = stack.pop();
            int result = 0;
            switch (token) {
                case "+":
                    result = number1 + number2;
                    break;
                case "-":
                    result = number1 - number2;
                    break;
                case "*":
                    result = number1 * number2;
                    break;
                case "/":
                    result = number1 / number2;
                    break;
            }
            stack.push(result);
        }
        return stack.pop();
    }
}
