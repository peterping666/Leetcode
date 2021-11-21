import java.util.ArrayDeque;
import java.util.Deque;

public class _85_MaximalRectangle {
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            if(matrix.length == 0) return 0;
            int n = matrix[0].length;
            int[] heights = new int[n];
            int max = 0;
            for(char[] row: matrix){
                for(int i = 0; i < n; i++){
                    if(row[i] == '1'){
                        heights[i] += 1;
                    } else {
                        heights[i] = 0;
                    }
                }

                max = Math.max(max, maxArea(heights));
            }
            return max;
        }

        public int maxArea(int[] heights){
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
}
