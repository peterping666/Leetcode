import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _56_MergeIntervals {
    /**
     * Time O(nlogn)
     * Space O(1)
     * @return
     */
    class Solution {
        public int[][] merge(int[][] intervals) {
            if(intervals.length == 0) {
                return new int[0][];
            }
            Arrays.sort(intervals, (a,b) -> {
                if(a[0] == b[0]) {
                    return 0;
                }
                return a[0] < b[0] ? -1 : 1;
            });
            List<int[]> res = new ArrayList<>();
            int left = intervals[0][0];
            int right = intervals[0][1];
            for(int i = 1; i < intervals.length; i++) {
                if(right >= intervals[i][0]) {
                    right = Math.max(right, intervals[i][1]);
                } else {
                    res.add(new int[]{left, right});
                    left = intervals[i][0];
                    right = intervals[i][1];
                }
            }
            res.add(new int[]{left, right});
            return res.toArray(new int[0][]);
        }
    }
}
