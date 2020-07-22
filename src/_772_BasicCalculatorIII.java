import java.util.ArrayDeque;
import java.util.Deque;

public class _772_BasicCalculatorIII {
    class Solution {
        public int calculate(String s) {
            if(s == null || s.length() == 0) {
                return 0;
            }
            Deque<Integer> stack = new ArrayDeque<>();
            char sign = '+';
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == ' ') {
                    continue;
                }
                if(Character.isDigit(c)) {
                    int num = c - '0';
                    while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                        i++;
                        num = num * 10 + (s.charAt(i) - '0');
                    }
                    addToStack(num, sign, stack);
                } else if(c == '(') {
                    int j = i + 1;
                    for(int count = 0; i < s.length(); i++) {
                        if(s.charAt(i) == '(') {
                            count++;
                        } else if(s.charAt(i) == ')') {
                            count--;
                        }
                        if(count == 0) {
                            break;
                        }
                    }
                    int num = calculate(s.substring(j, i));
                    addToStack(num, sign, stack);
                } else {
                    sign = c;
                }
            }
            int res = 0;
            while(!stack.isEmpty()) {
                res += stack.pollFirst();
            }
            return res;
        }

        private void addToStack(int num, char sign, Deque<Integer> stack) {
            if(sign == '+') {
                stack.offerFirst(num);
            } else if(sign == '-') {
                stack.offerFirst(-num);
            } else if(sign == '*') {
                stack.offerFirst(stack.pollFirst() * num);
            } else {
                stack.offerFirst(stack.pollFirst() / num);
            }
        }
    }
}
