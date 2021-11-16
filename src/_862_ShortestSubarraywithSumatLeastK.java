import java.util.ArrayDeque;
import java.util.Deque;

public class _862_ShortestSubarraywithSumatLeastK {
    class Solution {
        public int shortestSubarray(int[] nums, int k) {
            int n = nums.length;
            long[] prefixSum = new long[n + 1];
            for(int i = 0; i < n; i++) {
                prefixSum[i + 1] = prefixSum[i] + nums[i];
            }
            Deque<Integer> deque = new ArrayDeque<>();
            int res = n + 1;
            for(int i = 0; i <= n; i++) {
                while(!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= k) {
                    res = Math.min(res, i - deque.pollFirst());
                }
                while(!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
            }
            return res > n ? -1 : res;
        }
    }
}
