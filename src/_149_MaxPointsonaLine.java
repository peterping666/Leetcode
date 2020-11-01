import java.util.HashMap;

public class _149_MaxPointsonaLine {
    class Solution {
        /**
         * Time O(n^2)
         * Space O(n)
         * @param points
         * @return
         */
        public int maxPoints(int[][] points) {
            if(points == null || points.length == 0) return 0;
            if(points.length <= 2) return points.length;
            int res = 0;
            HashMap<String, Integer> map = new HashMap<>();
            for(int i = 0; i < points.length; i++) {
                map.clear();
                int samePoint = 0;
                int sameX = 0;
                for(int j = i + 1; j < points.length; j++) {
                    if(i != j) {
                        if(points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                            samePoint++;
                            sameX++;
                            res = Math.max(res, sameX + 1);
                        } else {
                            int numerator = points[i][1] - points[j][1];
                            int denominator = points[i][0] - points[j][0];
                            int gcd = gcd(numerator, denominator);
                            String slope = (numerator / gcd) + "/" + (denominator / gcd);
                            map.put(slope, map.getOrDefault(slope, 0) + 1);
                            res = Math.max(res, map.get(slope) + samePoint + 1);
                        }
                    }
                }
            }
            return res;
        }

        private int gcd(int a, int b) {
            while(a != 0) {
                int tmp = a;
                a = b % a;
                b = tmp;
            }
            return b;
        }
    }
}
