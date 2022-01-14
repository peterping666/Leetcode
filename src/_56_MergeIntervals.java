import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _56_MergeIntervals {
    /**
     * Time O(nlogn)
     * Space O(1)
     */
    class Solution1 {
        public int[][] merge(int[][] intervals) {
            if(intervals.length == 0) {
                return new int[0][];
            }
            Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
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

    class Solution2 {
        public int[][] merge(int[][] intervals) {
            if(intervals == null || intervals[0] == null) {
                return new int[0][];
            }
            Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
            List<int[]> res = new ArrayList<>();
            res.add(intervals[0]);
            for(int i = 1; i < intervals.length; i++) {
                int[] cur = res.get(res.size() - 1);
                if(cur[1] < intervals[i][0]) {
                    res.add(intervals[i]);
                } else {
                    cur[1] = Math.max(cur[1], intervals[i][1]);
                }
            }
            return res.toArray(new int[0][]);
        }
    }
}
