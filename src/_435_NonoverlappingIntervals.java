import java.util.Arrays;

public class _435_NonoverlappingIntervals {

    class Solution1 {
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));
            int res = 1;
            int end = intervals[0][1];
            for(int i = 1; i < intervals.length; i++) {
                if(intervals[i][0] >= end) {
                    res++;
                    end = intervals[i][1];
                }
            }
            return intervals.length - res;
        }
    }

    class Solution2 {
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> {
                if(a[1] == b[1]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            });
            int res = 0;
            int[] cur = intervals[0];
            for(int i = 1; i < intervals.length; i++) {
                if(intervals[i][0] < cur[1]) {
                    res++;
                } else {
                    cur = intervals[i];
                }
            }
            return res;
        }
    }
}
