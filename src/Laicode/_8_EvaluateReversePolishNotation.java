package Laicode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _8_EvaluateReversePolishNotation {
    public class Solution {
        public int evalRPN(String[] tokens) {
            // Write your solution here
            Deque<String> stack = new ArrayDeque<>();
            for(String token : tokens) {
                if(Character.isDigit(token.charAt(token.length() - 1))) {
                    stack.offerFirst(token);
                } else {
                    int num2 = Integer.valueOf(stack.pollFirst());
                    int num1 = Integer.valueOf(stack.pollFirst());
                    int result = 0;
                    if(token.equals("+")) {
                        result = num1 + num2;
                    } else if(token.equals("-")) {
                        result = num1 - num2;
                    } else if(token.equals("*")) {
                        result = num1 * num2;
                    } else {
                        result = num1 / num2;
                    }
                    stack.offerFirst(String.valueOf(result));
                }
            }
            return Integer.valueOf(stack.pollFirst());
        }
    }

}
