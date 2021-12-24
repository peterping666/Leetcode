import java.util.ArrayDeque;
import java.util.Deque;

public class _1130_MinimumCostTreeFromLeafValues {

    /**
     * Time O(n)
     * Space O(n)
     */
    class Solution {
        public int mctFromLeafValues(int[] arr) {
            int n = arr.length;
            Deque<Integer> stack = new ArrayDeque<>();
            int[] leftLarge = new int[n];
            for(int i = 0; i < n; i++) {
                while(!stack.isEmpty() && stack.peek() < arr[i]) {
                    stack.pop();
                }
                leftLarge[i] = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek();
                stack.push(arr[i]);
            }
            stack.clear();
            int[] rightLarge = new int[n];
            for(int i = n-1; i >= 0; i--) {
                while(!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
                rightLarge[i] = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek();
                stack.push(arr[i]);
            }
            int res = 0;
            for(int i = 0; i < n; i++) {
                int min = Math.min(leftLarge[i], rightLarge[i]);
                if(min != Integer.MAX_VALUE) {
                    res += arr[i] * min;
                }
            }
            return res;
        }
    }
}
