import java.util.Stack;

public class _1130_MinimumCostTreeFromLeafValues {
    class Solution {
        public int mctFromLeafValues(int[] arr) {
            int res = 0;
            Stack<Integer> stack = new Stack<>();
            stack.push(Integer.MAX_VALUE);
            for (int a : arr) {
                while (stack.peek() <= a) {
                    int mid = stack.pop();
                    res += mid * Math.min(stack.peek(), a);
                }
                stack.push(a);
            }
            while (stack.size() > 2) {
                res += stack.pop() * stack.peek();
            }
            return res;
        }
    }
}
