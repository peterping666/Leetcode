import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _593_ValidSquare {
    class Solution {
        public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
            Set<Integer> set = new HashSet<>(Arrays.asList(distance(p1, p2), distance(p1, p3), distance(p1, p4),
                    distance(p2, p3), distance(p2, p4), distance(p3, p4)));
            return !set.contains(0) && set.size() == 2;
        }

        private int distance(int[] a, int[] b) {
            return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
        }
    }
}
