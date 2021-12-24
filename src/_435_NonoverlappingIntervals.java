import java.util.Arrays;

public class _435_NonoverlappingIntervals {

    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));
            int right = intervals[0][1], res = 0;
            for(int i = 1; i < intervals.length; i++) {
                if(intervals[i][0] >= right) {
                    right = intervals[i][1];
                } else {
                    res++;
                }
            }
            return res;
        }
    }
}
