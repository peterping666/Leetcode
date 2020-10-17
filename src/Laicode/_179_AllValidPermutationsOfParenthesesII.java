package Laicode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _179_AllValidPermutationsOfParenthesesII {
    public class Solution {
        public List<String> validParentheses(int l, int m, int n) {
            char[] ps = new char[]{'(', ')', '<', '>', '{', '}'};
            int[] remain = new int[]{l, m, n};
            int targetLen = l * 2 + m * 2 + n * 2;
            List<String> result = new ArrayList<>();
            helper(result, ps, remain, new StringBuilder(), new ArrayDeque(), targetLen);
            return result;
        }

        private void helper(List<String> result, char[] ps, int[] remain, StringBuilder sb, Deque<Character> stack, int targetLen) {
            if(sb.length() == targetLen) {
                result.add(sb.toString());
                return;
            }
            for(int i = 0; i < ps.length; i++) {
                if(i % 2 == 0) {
                    if(remain[i / 2] > 0) {
                        sb.append(ps[i]);
                        stack.offerFirst(ps[i]);
                        remain[i / 2]--;
                        helper(result, ps, remain, sb, stack, targetLen);
                        sb.deleteCharAt(sb.length() - 1);
                        stack.pollFirst();
                        remain[i / 2]++;
                    }
                } else if(!stack.isEmpty() && ps[i - 1] == stack.peekFirst()) {
                    sb.append(ps[i]);
                    stack.pollFirst();
                    helper(result, ps, remain, sb, stack, targetLen);
                    sb.deleteCharAt(sb.length() - 1);
                    stack.offerFirst(ps[i - 1]);
                }
            }
        }
    }

}
