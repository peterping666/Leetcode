import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _241_DifferentWaystoAddParentheses {
    class Solution {
        public List<Integer> diffWaysToCompute(String expression) {
            return helper(expression, new HashMap<>());
        }

        private List<Integer> helper(String expression, Map<String, List<Integer>> memo) {
            if(memo.containsKey(expression)) {
                return memo.get(expression);
            }
            List<Integer> res = new ArrayList<>();
            for(int i = 0; i < expression.length(); i++) {
                char c = expression.charAt(i);
                if(c == '+' || c == '-' || c == '*') {
                    List<Integer> op1 = helper(expression.substring(0, i), memo);
                    List<Integer> op2 = helper(expression.substring(i + 1), memo);
                    for(int x : op1) {
                        for(int y : op2) {
                            if(c == '-') {
                                res.add(x - y);
                            } else if(c == '+') {
                                res.add(x + y);
                            } else {
                                res.add(x * y);
                            }
                        }
                    }
                }
            }
            if(res.isEmpty()) {
                res.add(Integer.valueOf(expression));
            }
            memo.put(expression, res);
            return res;
        }
    }
}
