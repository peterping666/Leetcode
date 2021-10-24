import java.util.ArrayDeque;
import java.util.Deque;

public class _227_BasicCalculatorII {
    /**
     * Time O(n)
     * Space O(n)
     * @return
     */
    class Solution {
        public int calculate(String s) {
            Deque<Integer> stack = new ArrayDeque<>();
            char sign = '+';
            for(int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if(Character.isDigit(ch)) {
                    int num = ch - '0';
                    while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                        num = num * 10 + s.charAt(++i) - '0';
                    }
                    if(sign == '+') {
                        stack.offerFirst(num);
                    } else if(sign == '-') {
                        stack.offerFirst(-num);
                    } else if(sign == '*') {
                        stack.offerFirst(stack.pollFirst() * num);
                    } else {
                        stack.offerFirst(stack.pollFirst() / num);
                    }
                } else if(ch != ' ') {
                    sign = ch;
                }
            }
            int res = 0;
            while(!stack.isEmpty()) {
                res += stack.pollFirst();
            }
            return res;
        }
    }
}
