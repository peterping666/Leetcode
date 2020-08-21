import java.util.ArrayList;
import java.util.List;

public class _22_GenerateParentheses {
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            helper(res, n, n, new StringBuilder());
            return res;
        }

        private void helper(List<String> res, int left, int right, StringBuilder path) {
            if(left == 0 && right == 0) {
                res.add(path.toString());
                return;
            }
            if(left > 0) {
                helper(res, left - 1, right, path.append('('));
                path.deleteCharAt(path.length() - 1);
            }
            if(right > left) {
                helper(res, left, right - 1, path.append(')'));
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
