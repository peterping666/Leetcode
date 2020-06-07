import java.util.Deque;
import java.util.LinkedList;

public class _239_SlidingWindowMaximum {
    /**
     * Time O(n)
     * Space O(n)
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length; i++) {
            if(!deque.isEmpty() && i - deque.peekFirst() + 1 > k) {
                deque.poll();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if(i + 1 >= k) {
                res[i - k + 1] = nums[deque.peek()];
            }
        }
        return res;
    }
}
