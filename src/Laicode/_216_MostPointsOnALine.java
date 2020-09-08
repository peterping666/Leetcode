package Laicode;

import java.util.HashMap;
import java.util.Map;

public class _216_MostPointsOnALine {
    public class Solution {
        public int most(Point[] points) {
            int res = 0;
            for(int i = 0; i < points.length; i++) {
                Point seed = points[i];
                int most = 0;
                int sameX = 0;
                int same = 1;
                Map<Double, Integer> map = new HashMap<>();
                for(int j = i + 1; j < points.length; j++) {
                    Point tmp = points[j];
                    if(tmp.x == seed.x && tmp.y == seed.y) {
                        same++;
                    } else if(tmp.x == seed.x) {
                        sameX++;
                    } else {
                        double slope = ((tmp.y - seed.y) + 0.0) / (tmp.x - seed.x);
                        map.put(slope, map.getOrDefault(slope, 0) + 1);
                        most = Math.max(most, map.get(slope));
                    }
                }
                most = Math.max(most, sameX) + same;
                res = Math.max(res, most);
            }
            return res;
        }
    }

    class Point {
        public int x;
        public int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
