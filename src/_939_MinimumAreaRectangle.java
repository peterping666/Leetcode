import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _939_MinimumAreaRectangle {
    class Solution {
        public int minAreaRect(int[][] points) {
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for(int[] point : points) {
                map.putIfAbsent(point[0], new HashSet<>());
                map.get(point[0]).add(point[1]);
            }
            int res = Integer.MAX_VALUE;
            for(int i = 0; i < points.length; i++) {
                for(int j = i + 1; j < points.length; j++) {
                    int x1 = points[i][0];
                    int y1 = points[i][1];
                    int x2 = points[j][0];
                    int y2 = points[j][1];
                    if(x1 == x2 || y1 == y2) {
                        continue;
                    }
                    if(map.get(x1).contains(y2) && map.get(x2).contains(y1)) {
                        res = Math.min(res, Math.abs(x1 - x2) * Math.abs(y1 - y2));
                    }
                }
            }
            return res == Integer.MAX_VALUE ? 0 : res;
        }
    }
}
