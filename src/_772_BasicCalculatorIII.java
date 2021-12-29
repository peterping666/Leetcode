import java.util.ArrayDeque;
import java.util.Deque;

public class _772_BasicCalculatorIII {
    class Solution {
        public int calculate(String s) {
            int n = s.length();
            Deque<Integer> stack = new ArrayDeque<>();
            char sign = '+';
            for(int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if(Character.isDigit(c)) {
                    int num = 0;
                    while(i < n && Character.isDigit(s.charAt(i))) {
                        num = num * 10 + s.charAt(i++) - '0';
                    }
                    i--;
                    if(sign == '+') {
                        stack.push(num);
                    } else if(sign == '-') {
                        stack.push(-num);
                    } else if(sign == '*') {
                        stack.push(stack.pop() * num);
                    } else {
                        stack.push(stack.pop() / num);
                    }
                } else if(c == '(') {
                    int count = 1, start = ++i;
                    while(count > 0) {
                        if(s.charAt(i) == ')') {
                            count--;
                        } else if(s.charAt(i) == '(') {
                            count++;
                        }
                        i++;
                    }
                    int num = calculate(s.substring(start, --i));
                    if(sign == '+') {
                        stack.push(num);
                    } else if(sign == '-') {
                        stack.push(-num);
                    } else if(sign == '*') {
                        stack.push(stack.pop() * num);
                    } else {
                        stack.push(stack.pop() / num);
                    }
                } else if(c == '+') {
                    sign = '+';
                } else if(c == '-') {
                    sign = '-';
                } else if(c == '*') {
                    sign = '*';
                } else if(c == '/') {
                    sign = '/';
                }
            }
            int res = 0;
            while(!stack.isEmpty()) {
                res += stack.pop();
            }
            return res;
        }
    }
}
