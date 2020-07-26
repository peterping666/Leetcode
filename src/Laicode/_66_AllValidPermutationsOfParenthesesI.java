package Laicode;

import java.util.ArrayList;
import java.util.List;

public class _66_AllValidPermutationsOfParenthesesI {
    public class Solution {
        public List<String> validParentheses(int n) {
            List<String> res = new ArrayList<>();
            helper(res, n, n, new StringBuilder());
            return res;
        }

        private void helper(List<String> res, int left, int right, StringBuilder path) {
            if(left == 0 && right == 0) {
                res.add(path.toString());
            }
            if(left > 0) {
                helper(res, left - 1, right, path.append('('));
                path.deleteCharAt(path.length() - 1);
            }
            if(left < right) {
                helper(res, left, right - 1, path.append(')'));
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

}
