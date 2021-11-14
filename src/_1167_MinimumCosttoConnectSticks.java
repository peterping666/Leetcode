import java.util.PriorityQueue;
import java.util.Queue;

public class _1167_MinimumCosttoConnectSticks {
    class Solution {
        public int connectSticks(int[] sticks) {
            Queue<Integer> minHeap = new PriorityQueue<>();
            for(int stick : sticks) {
                minHeap.offer(stick);
            }
            int res = 0;
            while(minHeap.size() > 1) {
                int first = minHeap.poll();
                int second = minHeap.poll();
                res += first + second;
                minHeap.offer(first + second);
            }
            return res;
        }
    }
}
