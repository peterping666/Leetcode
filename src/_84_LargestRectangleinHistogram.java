import java.util.ArrayDeque;
import java.util.Deque;

public class _84_LargestRectangleinHistogram {
    /**
     * Time O(n)
     * Space O(n)
     */
    class Solution {
        public int largestRectangleArea(int[] heights) {
            Deque<Integer> stack = new ArrayDeque<>();
            stack.offerFirst(-1);
            int maxArea = 0;
            for(int i = 0; i < heights.length; i++) {
                while(stack.peekFirst() != -1 && heights[i] <= heights[stack.peekFirst()]) {
                    maxArea = Math.max(maxArea, heights[stack.pollFirst()] * (i - stack.peekFirst() - 1));
                }
                stack.offerFirst(i);
            }
            while(stack.peekFirst() != -1) {
                maxArea = Math.max(maxArea, heights[stack.pollFirst()] * (heights.length - stack.peekFirst() - 1));
            }
            return maxArea;
        }
    }
}
