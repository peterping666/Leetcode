import java.util.Stack;

public class _456_132Pattern {
    /**
     * Time O(n)
     * Space O(n)
     * @param nums
     * @return
     */
    public boolean find132pattern(int[] nums) {
        int mid = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] < mid) {
                return true;
            } else {
                while(!stack.isEmpty() && nums[i] > stack.peek()) {
                    mid = stack.pop();
                }
                stack.push(nums[i]);
            }
        }
        return false;
    }
}
