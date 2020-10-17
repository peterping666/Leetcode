package Laicode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _642_AllValidPermutationsOfParenthesesIII {
    public class Solution {
        public List<String> validParenthesesIII(int l, int m, int n) {
            List<String> res = new ArrayList<>();
            // if i is odd, i - 1 and i matches each other
            char[] signs = new char[]{'(', ')', '<', '>', '{', '}'};
            int[] count = new int[]{l, m, n};
            int targetLength = l * 2 + m * 2 + n * 2;
            helper(res, signs, count, new StringBuilder(), targetLength, new ArrayDeque<>());
            return res;
        }

        private void helper(List<String> res, char[] signs, int[] count, StringBuilder sb,
                            int targetLength, Deque<Integer> stack) {
            if(sb.length() == targetLength) {
                res.add(sb.toString());
                return;
            }
            // i is the index of signs
            for(int i = 0; i < signs.length; i++) {
                // i is even, we are looking at the left sign
                if(i % 2 == 0) {
                    if(count[i / 2] > 0 && (stack.isEmpty() || stack.peekFirst() > i)) {
                        sb.append(signs[i]);
                        count[i / 2]--;
                        stack.offerFirst(i);
                        helper(res, signs, count, sb, targetLength, stack);
                        count[i / 2]++;
                        sb.deleteCharAt(sb.length() - 1);
                        stack.pollFirst();
                    }
                } else {
                    if(!stack.isEmpty() && stack.peekFirst() == i - 1) {
                        sb.append(signs[i]);
                        stack.pollFirst();
                        helper(res, signs, count, sb, targetLength, stack);
                        sb.deleteCharAt(sb.length() - 1);
                        stack.offerFirst(i - 1);
                    }
                }
            }
        }
    }

}
