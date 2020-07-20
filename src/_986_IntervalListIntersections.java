import java.util.ArrayList;
import java.util.List;

public class _986_IntervalListIntersections {
    class Solution {
        public int[][] intervalIntersection(int[][] A, int[][] B) {
            List<int[]> res = new ArrayList();
            int i = 0, j = 0;
            while (i < A.length && j < B.length) {
                int lo = Math.max(A[i][0], B[j][0]);
                int hi = Math.min(A[i][1], B[j][1]);
                if (lo <= hi)
                    res.add(new int[]{lo, hi});
                if (A[i][1] < B[j][1])
                    i++;
                else
                    j++;
            }

            return res.toArray(new int[0][]);
        }
    }
}
