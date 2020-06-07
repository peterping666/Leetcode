import java.util.TreeMap;

public class _436_FindRightInterval {
    /**
     * Time O(nlogn)
     * Space O(n)
     */

    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] res = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i);
        }
        for(int i = 0; i < intervals.length; i++) {
            Integer key = map.ceilingKey(intervals[i][1]);
            res[i] = key == null ? -1 : map.get(key);
        }
        return res;
    }
}
