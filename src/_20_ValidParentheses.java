import java.util.ArrayDeque;
import java.util.Deque;

public class _20_ValidParentheses {
    /**
     * Time O(n)
     * Space O(n)
     */
    class Solution {
        public boolean isValid(String s) {
            Deque<Character> stack = new ArrayDeque<>();
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == '(') {
                    stack.offerFirst(')');
                } else if(c == '{') {
                    stack.offerFirst('}');
                } else if(c == '[') {
                    stack.offerFirst(']');
                } else if(stack.isEmpty() || stack.pollFirst() != c){
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }
}
