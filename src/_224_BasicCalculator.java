import java.util.ArrayDeque;
import java.util.Deque;

public class _224_BasicCalculator {
    /**
     * Time O(n)
     * Space O(n)
     * @return
     */
    class Solution {
        public int calculate(String s) {
            Deque<Integer> stack = new ArrayDeque<>();
            int sign = 1;
            int curNum = 0;
            for(int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if(Character.isDigit(ch)) {
                    int num = ch - '0';
                    while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                        num = num * 10 + s.charAt(i + 1) - '0';
                        i++;
                    }
                    curNum += sign * num;
                } else if(ch == '+') {
                    sign = 1;
                } else if(ch == '-') {
                    sign = -1;
                } else if(ch == '(') {
                    stack.offerFirst(curNum);
                    stack.offerFirst(sign);
                    curNum = 0;
                    sign = 1;
                } else if(ch == ')') {
                    curNum = stack.pollFirst() * curNum + stack.pollFirst();
                }
            }
            return curNum;
        }
    }
}
