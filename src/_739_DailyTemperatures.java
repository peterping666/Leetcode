import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class _739_DailyTemperatures {
    class Solution1 {
        public int[] dailyTemperatures(int[] T) {
            Deque<int[]> stack = new ArrayDeque<>();
            int[] res = new int[T.length];
            for(int i = 0; i < T.length; i++) {
                while(!stack.isEmpty() && stack.peekFirst()[0] < T[i]) {
                    int index = stack.pollFirst()[1];
                    res[index] = i - index;
                }
                stack.offerFirst(new int[]{T[i], i});
            }
            return res;
        }
    }

    class Solution2 {
        public int[] dailyTemperatures(int[] T) {
            int[] ans = new int[T.length];
            Stack<Integer> stack = new Stack();
            for (int i = T.length - 1; i >= 0; --i) {
                while (!stack.isEmpty() && T[i] >= T[stack.peek()]) stack.pop();
                ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
                stack.push(i);
            }
            return ans;
        }
    }
}
