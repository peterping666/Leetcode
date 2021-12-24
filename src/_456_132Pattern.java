import java.util.ArrayDeque;
import java.util.Deque;

public class _456_132Pattern {
    /**
     * Time O(n)
     * Space O(n)
     */
    class Solution {
        public boolean find132pattern(int[] nums) {
            Deque<Integer> stack = new ArrayDeque<>();
            int n = nums.length, right = Integer.MIN_VALUE;
            for(int i = n-1; i >= 0; i--) {
                if(nums[i] < right) {
                    return true;
                }
                while(!stack.isEmpty() && stack.peek() < nums[i]) {
                    right = stack.pop();
                }
                stack.push(nums[i]);
            }
            return false;
        }
    }
}
