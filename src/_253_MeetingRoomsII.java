import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class _253_MeetingRoomsII {
    /**
     * Time O(nlogn)
     * Space O(n)
     * @return
     */
    class Solution {
        public int minMeetingRooms(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
            Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
            for(int[] interval : intervals) {
                if(!minHeap.isEmpty() && minHeap.peek()[1] <= interval[0]) {
                    minHeap.poll();
                }
                minHeap.offer(interval);
            }
            return minHeap.size();
        }
    }
}
