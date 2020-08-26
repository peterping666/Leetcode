import java.util.ArrayList;
import java.util.List;

public class    _986_IntervalListIntersections {
    class Solution {
        public int[][] intervalIntersection(int[][] A, int[][] B) {
            List<int[]> res= new ArrayList<>();
            int aIndex = 0;
            int bIndex = 0;
            while(aIndex < A.length && bIndex < B.length) {
                int low = Math.max(A[aIndex][0], B[bIndex][0]);
                int high = Math.min(A[aIndex][1], B[bIndex][1]);
                if(low <= high) {
                    res.add(new int[]{low, high});
                }
                if(A[aIndex][1] < B[bIndex][1]) {
                    aIndex++;
                } else {
                    bIndex++;
                }
            }
            return res.toArray(new int[0][]);
        }
    }
}
