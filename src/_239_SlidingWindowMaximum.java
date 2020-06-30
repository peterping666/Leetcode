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
    public int[] maxSlidingWindow1(int[] nums, int k) {
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

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length - k + 1;
        int[] res = new int[n];
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0, j = 0; i < nums.length; i++) {
            if(!deque.isEmpty() && i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if(i >= k-1) {
                res[j++] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
