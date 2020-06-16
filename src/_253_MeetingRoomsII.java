import java.util.Arrays;
import java.util.PriorityQueue;

public class _253_MeetingRoomsII {
    /**
     * Time O(nlogn)
     * Space O(n)
     * @param intervals
     * @return
     */
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for(int[] interval : intervals) {
            if(heap.isEmpty() || heap.peek()[1] > interval[0]) {
                heap.offer(interval);
            } else {
                heap.poll();
                heap.offer(interval);
            }
        }
        return heap.size();
    }
}
