import java.util.HashMap;

public class _149_MaxPointsonaLine {
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
        for(int i = 0; i < points.length; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int samePoint = 0;
            int sameXAxis = 1;
            for(int j = 0; j < points.length; j++) {
                if(i != j) {
                    if(points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                        samePoint++;
                    }
                    if(points[i][0] == points[j][0]) {
                        sameXAxis++;
                        continue;
                    }
                    int numerator = points[i][1] - points[j][1];
                    int denominator = points[i][0] - points[j][0];
                    int gcd = gcd(numerator, denominator);
                    String hashStr = (numerator / gcd) + "/" + (denominator / gcd);
                    map.put(hashStr, map.getOrDefault(hashStr, 1) + 1);
                    res = Math.max(res, map.get(hashStr) + samePoint);
                }
            }
            res = Math.max(res, sameXAxis);
        }
        return res;
    }

    private int gcd(int a, int b) {
        if(a == 0) return b;
        return gcd(b % a, a);
    }
}
