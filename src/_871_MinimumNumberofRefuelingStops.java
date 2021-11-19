import java.util.PriorityQueue;
import java.util.Queue;

public class _871_MinimumNumberofRefuelingStops {
    class Solution {
        public int minRefuelStops(int target, int startFuel, int[][] stations) {
            int cur = startFuel;
            int res = 0;
            Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b.compareTo(a));
            for(int[] station : stations) {
                while(!maxHeap.isEmpty() && cur < station[0]) {
                    cur += maxHeap.poll();
                    res++;
                }
                if(cur < station[0]) {
                    return -1;
                }
                maxHeap.offer(station[1]);
            }
            while(!maxHeap.isEmpty() && cur < target) {
                cur += maxHeap.poll();
                res++;
            }
            if(cur < target) {
                return -1;
            }
            return res;
        }
    }
}
