import java.util.ArrayDeque;
import java.util.Deque;

public class _795_NumberofSubarrayswithBoundedMaximum {

    /**
     * Time O(n)
     * Space O(1)
     */
    class Solution1 {
        public int numSubarrayBoundedMax(int[] nums, int left, int right) {
            int res = 0, dp = 0, prev = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < left) {
                    res += dp;
                }
                else if (nums[i] > right) {
                    dp = 0;
                    prev = i;
                }
                else if (left <= nums[i] && nums[i] <= right) {
                    dp = i - prev;
                    res += dp;
                }
            }
            return res;
        }
    }

    /**
     * Time O(n)
     * Space O(n)
     */
    class Solution2 {
        public int numSubarrayBoundedMax(int[] nums, int left, int right) {
            int n = nums.length;
            Deque<Integer> stack = new ArrayDeque<>();
            int[] leftLess = new int[n];
            int[] rightLess = new int[n];
            for(int i = 0; i < n; i++) {
                while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                    rightLess[stack.pop()] = i;
                }
                leftLess[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            while(!stack.isEmpty()) {
                rightLess[stack.pop()] = n;
            }

            int res = 0;
            for(int i = 0; i < n; i++) {
                if(nums[i] >= left && nums[i] <= right) {
                    res += (i - leftLess[i]) * (rightLess[i] - i);
                }
            }
            return res;
        }
    }

    /**
     * Time O(n)
     * Space O(n)
     */
    class Solution3 {
        public int numSubarrayBoundedMax(int[] nums, int left, int right) {
            int n = nums.length;
            Deque<Integer> stack = new ArrayDeque<>();
            int[] leftLess = new int[n];
            for(int i = 0; i < n; i++) {
                while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                    stack.pop();
                }
                leftLess[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            stack.clear();
            int[] rightLess = new int[n];
            for(int i = n - 1; i >= 0; i--) {
                while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                    stack.pop();
                }
                rightLess[i] = stack.isEmpty() ? n : stack.peek();
                stack.push(i);
            }
            int res = 0;
            for(int i = 0; i < n; i++) {
                if(nums[i] >= left && nums[i] <= right) {
                    res += (i - leftLess[i]) * (rightLess[i] - i);
                }
            }
            return res;
        }
    }
}
