import java.util.ArrayList;
import java.util.List;

public class _301_RemoveInvalidParentheses {
    class Solution {
        public List<String> removeInvalidParentheses(String s) {
            List<String> output = new ArrayList<>();
            removeHelper(s, output, 0, 0, '(', ')');
            return output;
        }

        public void removeHelper(String s, List<String> output, int iStart, int jStart, char openParen, char closedParen) {
            int numOpenParen = 0;
            int numClosedParen = 0;
            for (int i = iStart; i < s.length(); i++) {
                if (s.charAt(i) == openParen) {
                    numOpenParen++;
                }
                if (s.charAt(i) == closedParen) {
                    numClosedParen++;
                }
                if (numClosedParen > numOpenParen) {
                    for (int j = jStart; j <= i; j++)
                        if (s.charAt(j) == closedParen && (j == jStart || s.charAt(j - 1) != closedParen))
                            removeHelper(s.substring(0, j) + s.substring(j + 1, s.length()), output, i, j, openParen, closedParen);
                    return;
                }
            }
            // No invalid closed parenthesis detected. Now check opposite direction, or reverse back to original direction.
            String reversed = new StringBuilder(s).reverse().toString();
            if (openParen == '(')
                removeHelper(reversed, output, 0, 0, ')','(');
            else
                output.add(reversed);
        }
    }
}
