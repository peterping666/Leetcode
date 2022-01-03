import java.util.ArrayList;
import java.util.List;

public class _282_ExpressionAddOperators {
    class Solution {
        public List<String> addOperators(String num, int target) {
            List<String> res = new ArrayList<>();
            helper(num, res, target, "", 0, 0, 0);
            return res;
        }

        private void helper(String num, List<String> res, int target, String cur, long sum, int start, long last) {
            if(start == num.length()) {
                if(sum == target) {
                    res.add(cur);
                }
            }
            for(int i = start; i < num.length(); i++) {
                if(i != start && num.charAt(start) == '0') {
                    continue;
                }
                long val = Long.valueOf(num.substring(start, i + 1));
                if(start == 0) {
                    helper(num, res, target, cur + val, sum + val, i + 1, val);
                } else {
                    helper(num, res, target, cur + '+' + val, sum + val, i + 1, val);
                    helper(num, res, target, cur + '-' + val, sum - val, i + 1, -val);
                    helper(num, res, target, cur + '*' + val, sum - last + last * val, i + 1, last * val);
                }
            }
        }
    }
}
