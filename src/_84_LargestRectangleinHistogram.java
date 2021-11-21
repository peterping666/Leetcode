import java.util.ArrayDeque;
import java.util.Deque;

public class _84_LargestRectangleinHistogram {
    /**
     * Time O(n)
     * Space O(n)
     */
    class Solution1 {
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(-1);
            int res = 0;
            for(int i = 0; i < n; i++) {
                while(stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                    res = Math.max(res, heights[stack.pop()] * (i - stack.peek() - 1));
                }
                stack.push(i);
            }
            while(stack.peek() != -1) {
                res = Math.max(res, heights[stack.pop()] * (n - stack.peek() - 1));
            }
            return res;
        }
    }

    class Solution2 {
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            int[] left = new int[n];
            Deque<Integer> stack = new ArrayDeque<>();
            for(int i = 0; i < n; i++) {
                while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    stack.poll();
                }
                left[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }

            int[] right = new int[n];
            stack.clear();
            for(int i = n - 1; i >= 0; i--) {
                while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    stack.poll();
                }
                right[i] = stack.isEmpty() ? n : stack.peek();
                stack.push(i);
            }

            int res = 0;
            for(int i = 0; i < n; i++) {
                res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
            }
            return res;
        }
    }
}
