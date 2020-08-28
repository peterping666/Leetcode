import java.util.ArrayDeque;
import java.util.Deque;

public class _739_DailyTemperatures {
    /**
     * Time O(n)
     * Space O(1)
     */
    class Solution {
        public int[] dailyTemperatures(int[] T) {
            Deque<Integer> stack = new ArrayDeque<>();
            int[] res = new int[T.length];
            for(int i = 0; i < T.length; i++) {
                while(!stack.isEmpty() && T[stack.peekFirst()] < T[i]) {
                    int day = stack.pollFirst();
                    res[day] = i - day;
                }
                stack.offerFirst(i);
            }
            return res;
        }
    }
}
