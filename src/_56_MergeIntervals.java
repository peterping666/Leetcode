import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _56_MergeIntervals {
    /**
     * Time O(nlogn)
     * Space O(1)
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return new int[0][];
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        int l = intervals[0][0];
        int r = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            if(r >= intervals[i][0]) {
                r = Math.max(r, intervals[i][1]);
            } else {
                list.add(new int[]{l, r});
                l = intervals[i][0];
                r = intervals[i][1];
            }
        }
        list.add(new int[]{l, r});
        return list.toArray(new int[0][]);
    }
}
