public class _1007_MinimumDominoRotationsForEqualRow {
    class Solution {
        public int minDominoRotations(int[] A, int[] B) {
            int n = A.length;
            int[] countA = new int[7];
            int[] countB = new int[7];
            int[] same = new int[7];
            for(int i = 0; i < n; i++) {
                countA[A[i]]++;
                countB[B[i]]++;
                if(A[i] == B[i]) {
                    same[A[i]]++;
                }
            }
            for(int i = 1; i <= 6; i++) {
                if(countA[i] + countB[i] - same[i] == n) {
                    return n - Math.max(countA[i], countB[i]);
                }
            }
            return -1;
        }
    }
}
