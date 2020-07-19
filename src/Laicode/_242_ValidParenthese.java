package Laicode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _242_ValidParenthese {
    public class Solution {
        /**
         *
         * @param input
         * @return
         */
        public boolean isValid(String input) {
            Deque<Character> stack = new ArrayDeque<>();

            for(int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if(c == ')') {
                    if(stack.isEmpty() || stack.pollFirst() != '(') {
                        return false;
                    }
                } else if(c == '}') {
                    if(stack.isEmpty() || stack.pollFirst() != '{') {
                        return false;
                    }
                } else if(c == ']') {
                    if(stack.isEmpty() || stack.pollFirst() != '[') {
                        return false;
                    }
                } else {
                    stack.offerFirst(c);
                }
            }
            return stack.isEmpty();

        }
    }

}
