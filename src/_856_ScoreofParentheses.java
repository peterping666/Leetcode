import java.util.Stack;

public class _856_ScoreofParentheses {
    class Solution1 {
        public int scoreOfParentheses(String S) {
            Stack<Integer> stack = new Stack<>();
            int cur = 0;
            for (char c : S.toCharArray()) {
                if (c == '(') {
                    stack.push(cur);
                    cur = 0;
                } else {
                    cur = stack.pop() + Math.max(cur * 2, 1);
                }
            }
            return cur;
        }
    }

    public int scoreOfParentheses(String S) {
        int res = 0, l = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') l++; else l--;
            if (S.charAt(i) == ')' && S.charAt(i - 1) == '(') res += 1 << l;
        }
        return res;
    }
}
