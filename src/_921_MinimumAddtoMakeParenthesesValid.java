import java.util.ArrayDeque;
import java.util.Deque;

public class _921_MinimumAddtoMakeParenthesesValid {
    class Solution1 {
        public int minAddToMakeValid(String s) {
            Deque<Character> stack = new ArrayDeque<>();
            int res = 0;
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == '(') {
                    stack.offerFirst(c);
                } else if(!stack.isEmpty()) {
                    stack.pollFirst();
                } else {
                    res++;
                }
            }
            return res + stack.size();
        }
    }

    class Solution2 {
        public int minAddToMakeValid(String s) {
            int left = 0;
            int right = 0;
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == '(') {
                    left++;
                } else if(left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
            return left + right;
        }
    }
}
