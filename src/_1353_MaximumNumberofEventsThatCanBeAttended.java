import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class _1353_MaximumNumberofEventsThatCanBeAttended {
    class Solution {
        public int maxEvents(int[][] events) {
            Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
            Queue<Integer> minHeap = new PriorityQueue<>();
            int i = 0;
            int res = 0;
            for(int day = 1; day <= 100000; day++) {
                while(!minHeap.isEmpty() && minHeap.peek() < day) {
                    minHeap.poll();
                }
                while(i < events.length && events[i][0] == day) {
                    minHeap.offer(events[i++][1]);
                }
                if(!minHeap.isEmpty()) {
                    minHeap.poll();
                    res++;
                }
            }
            return res;
        }
    }
}
