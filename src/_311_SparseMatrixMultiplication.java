public class _311_SparseMatrixMultiplication {
    class Solution {
        public int[][] multiply(int[][] A, int[][] B) {
            int m = A.length;
            int n = B.length;
            int t = B[0].length;
            int[][] matrix = new int[m][t];
            for(int i = 0; i < m; i++) {
                for(int k = 0; k < n; k++) {
                    if(A[i][k] == 0) continue;
                    for(int j = 0; j < t; j++) {
                        matrix[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
            return matrix;
        }
    }
}
