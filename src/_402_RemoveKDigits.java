import java.util.ArrayDeque;
import java.util.Deque;

public class _402_RemoveKDigits {
    /**
     * Time O(n)
     * Space O(n)
     */
    class Solution {
        public String removeKdigits(String num, int k) {
            Deque<Character> deque = new ArrayDeque<>();
            for(int i = 0; i < num.length(); i++) {
                char ch = num.charAt(i);
                while(k > 0 && !deque.isEmpty() && deque.peekLast() > ch) {
                    deque.pollLast();
                    k--;
                }
                deque.offerLast(ch);
            }
            while(k > 0) {
                deque.pollLast();
                k--;
            }
            StringBuilder sb = new StringBuilder();
            while(!deque.isEmpty()) {
                char c = deque.pollFirst();
                if(sb.length() == 0 && c == '0') {
                    continue;
                }
                sb.append(c);
            }
            return sb.length() == 0 ? "0" : sb.toString();
        }
    }
}
