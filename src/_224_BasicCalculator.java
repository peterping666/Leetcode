import java.util.Stack;

public class _224_BasicCalculator {
    /**
     * Time O(n)
     * Space O(n)
     * @param s
     * @return
     */
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int res = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int num = ch - '0';
                while(i + 1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    num = num * 10 + s.charAt(i+1) - '0';
                    i++;
                }
                res += num * sign;
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (ch == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (ch == ')') {
                res = res * stack.pop() + stack.pop();
            }
        }
        return res;
    }
}
