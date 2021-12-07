import java.util.ArrayDeque;
import java.util.Deque;

public class _581_ShortestUnsortedContinuousSubarray {

    /**
     * Time O(n)
     * Space O(1)
     */
    class Solution1 {
        public int findUnsortedSubarray(int[] nums) {
            int n = nums.length, left = -1, right = -2, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for(int i = 0; i < n-1; i++) {
                if(nums[i] > nums[i+1]) {
                    min = Math.min(min, nums[i+1]);
                    max = Math.max(max, nums[i]);
                }
            }
            for(int i = 0; i < n; i++) {
                if(nums[i] > min) {
                    left = i;
                    break;
                }
            }
            for(int i = n-1; i >= 0; i--) {
                if(nums[i] < max) {
                    right = i;
                    break;
                }
            }
            return right - left + 1;
        }
    }

    /**
     * Time O(n)
     * Space O(1)
     */
    class Solution2 {
        public int findUnsortedSubarray(int[] nums) {
            int n = nums.length, left = -1, right = -2, min = nums[n-1], max = nums[0];
            for(int i = 1; i < n; i++) {
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[n-i-1]);

                if(nums[i] < max) {
                    right = i;
                }
                if(nums[n-i-1] > min) {
                    left = n-i-1;
                }
            }

            return right - left + 1;
        }
    }

    /**
     * Time O(n)
     * Sapce o(n)
     */
    class Solution3 {
        public int findUnsortedSubarray(int[] nums) {
            int n = nums.length, left = n, right = -1;
            Deque<Integer> stack = new ArrayDeque<>();
            for(int i = 0; i < n; i++) {
                while(!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                    left = Math.min(left, stack.pop());
                }
                stack.push(i);
            }
            stack.clear();
            for(int i = n-1; i >= 0; i--) {
                while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                    right = Math.max(right, stack.pop());
                }
                stack.push(i);
            }
            return right > left ? right - left + 1 : 0;
        }
    }
}
