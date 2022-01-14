import java.util.ArrayList;
import java.util.List;

public class _57_InsertInterval {
    /**
     * Time O(n)
     * Space O(n)
     */
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            int i = 0, n = intervals.length;
            List<int[]> res = new ArrayList<>();
            while(i < n && intervals[i][1] < newInterval[0]) {
                res.add(intervals[i++]);
            }

            int left = newInterval[0];
            int right = newInterval[1];
            while(i < n && right >= intervals[i][0]) {
                left = Math.min(left, intervals[i][0]);
                right = Math.max(right, intervals[i][1]);
                i++;
            }
            res.add(new int[]{left, right});

            while(i < n) {
                res.add(intervals[i++]);
            }
            return res.toArray(new int[0][]);
        }
    }
}
