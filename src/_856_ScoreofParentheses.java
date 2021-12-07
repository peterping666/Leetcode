import java.util.ArrayDeque;
import java.util.Deque;

public class _856_ScoreofParentheses {
    class Solution {
        public int scoreOfParentheses(String s) {
            Deque<Integer> stack = new ArrayDeque<>();
            int cur = 0;
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == ')') {
                    if(cur == 0) {
                        cur = 1;
                    } else {
                        cur *= 2;
                    }
                    cur += stack.pop();
                } else {
                    stack.push(cur);
                    cur = 0;
                }
            }
            return cur;
        }
    }
}
