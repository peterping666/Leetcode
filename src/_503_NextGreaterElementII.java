import java.util.ArrayDeque;
import java.util.Deque;

public class _503_NextGreaterElementII {
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            Deque<Integer> stack = new ArrayDeque<>();
            int n = nums.length;
            int[] res = new int[n];
            for(int i = 0; i < n * 2 - 1; i++) {
                int num = nums[i % n];
                while(!stack.isEmpty() && nums[stack.peekFirst()] < num) {
                    res[stack.pollFirst()] = num;
                }
                if (i < n) {
                    stack.offerFirst(i);
                }
            }
            while(!stack.isEmpty()) {
                res[stack.pollFirst()] = -1;
            }
            return res;
        }
    }
}
