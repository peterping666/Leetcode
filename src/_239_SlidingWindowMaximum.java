import java.util.ArrayDeque;
import java.util.Deque;

public class _239_SlidingWindowMaximum {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            int[] res = new int[n - k + 1];
            Deque<Integer> deque = new ArrayDeque<>();
            for(int i = 0; i < nums.length; i++) {
                while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
                if(i - deque.peekFirst() >= k) {
                    deque.pollFirst();
                }
                if(i - k + 1 >= 0) {
                    res[i - k + 1] = nums[deque.peekFirst()];
                }
            }
            return res;
        }
    }
}
