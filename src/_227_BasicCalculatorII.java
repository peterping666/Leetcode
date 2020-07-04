import java.util.Stack;

public class _227_BasicCalculatorII {
    /**
     * Time O(n)
     * Space O(n)
     * @param s
     * @return
     */
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                int num = ch - '0';
                while(i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    num = num * 10 + s.charAt(i+1) - '0';
                    i++;
                }
                if(sign == '+') {
                    stack.push(num);
                } else if(sign == '-') {
                    stack.push(-num);
                } else if(sign == '*') {
                    stack.push(num * stack.pop());
                } else {
                    stack.push(stack.pop() / num);
                }
            } else if(ch != ' ') {
                sign = ch;
            }
        }
        int sum = 0;
        for(int num : stack) {
            sum += num;
        }
        return sum;
    }
}
