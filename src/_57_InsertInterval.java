import java.util.ArrayList;
import java.util.List;

public class _57_InsertInterval {
    /**
     * Time O(n)
     * Space O(n)
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int index = 0;
        List<int[]> list = new ArrayList<>();
        while(index < intervals.length && intervals[index][1] < newInterval[0]) {
            list.add(intervals[index++]);
        }
        int l = newInterval[0];
        int r = newInterval[1];
        while(index < intervals.length && r >= intervals[index][0]) {
            l = Math.min(l, intervals[index][0]);
            r = Math.max(r, intervals[index][1]);
            index++;
        }
        list.add(new int[]{l, r});
        while(index < intervals.length) {
            list.add(intervals[index++]);
        }
        return list.toArray(new int[0][]);
    }
}
