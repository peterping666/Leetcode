import java.util.ArrayDeque;
import java.util.Deque;

public class _402_RemoveKDigits {
    /**
     * Time O(n)
     * Space O(n)
     * @return
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
            boolean leadingZero = true;
            while(!deque.isEmpty()) {
                char digit = deque.pollFirst();
                if(leadingZero && digit == '0') {
                    continue;
                }
                leadingZero = false;
                sb.append(digit);
            }
            return sb.length() == 0 ? "0" : sb.toString();
        }
    }
}
