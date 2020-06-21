import java.util.Arrays;
import java.util.Stack;

public class _503_NextGreaterElementII {
    /**
     * Time O(n)
     * Space O(n)
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(res, -1);
        for(int i = 0; i < nums.length * 2; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length]) {
                res[stack.pop()] = nums[i % nums.length];
            }
            if(i < nums.length) {
                stack.push(i);
            }
        }
        return res;
    }
}
