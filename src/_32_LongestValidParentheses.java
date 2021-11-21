import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class _32_LongestValidParentheses {

    class Solution {
        public int longestValidParentheses(String s) {
            Deque<Integer> stack = new ArrayDeque<>();
            int res = 0;
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == '(' || stack.isEmpty() || s.charAt(stack.peek()) == ')'){
                    stack.push(i);
                } else {
                    stack.pop();
                    int left = stack.isEmpty() ? -1 : stack.peek();
                    res = Math.max(res, i - left);
                }

            }
            return res;
        }
    }
}
