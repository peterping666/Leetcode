import java.util.ArrayList;
import java.util.List;

public class _57_InsertInterval {
    /**
     * Time O(n)
     * Space O(n)
     */
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            int index = 0, n = intervals.length;
            List<int[]> res = new ArrayList<>();
            while(index < n && intervals[index][1] < newInterval[0]) {
                res.add(intervals[index++]);
            }
            while(index < n && intervals[index][0] <= newInterval[1]) {
                newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
                index++;
            }
            res.add(newInterval);
            while(index < n) {
                res.add(intervals[index++]);
            }
            return res.toArray(new int[0][]);
        }
    }
}
