import java.util.Stack;

public class _844_BackspaceStringCompare {
    /**
     * Time O(n)
     * Space O(n)
     */
    class Solution {
        public boolean backspaceCompare(String S, String T) {
            return build(S).equals(build(T));
        }

        public String build(String S) {
            Stack<Character> ans = new Stack();
            for (char c: S.toCharArray()) {
                if (c != '#')
                    ans.push(c);
                else if (!ans.empty())
                    ans.pop();
            }
            return String.valueOf(ans);
        }
    }

    /**
     * Time O(n)
     * Space O(1)
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1, back;
        while (true) {
            back = 0;
            while (i >= 0 && (back > 0 || S.charAt(i) == '#')) {
                back += S.charAt(i) == '#' ? 1 : -1;
                i--;
            }
            back = 0;
            while (j >= 0 && (back > 0 || T.charAt(j) == '#')) {
                back += T.charAt(j) == '#' ? 1 : -1;
                j--;
            }
            if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
                i--;
                j--;
            } else {
                break;
            }
        }
        return i == -1 && j == -1;
    }
}
