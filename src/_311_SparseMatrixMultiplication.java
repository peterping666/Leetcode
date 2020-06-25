public class _311_SparseMatrixMultiplication {
    /**
     *
     * @param A
     * @param B
     * @return
     */
    public int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;
        int m = A[0].length;
        int t = B[0].length;
        int[][] matrix = new int[n][t];
        for(int i = 0; i < n; i++) {
            for(int k = 0; k < m; k++) {
                if(A[i][k] == 0) continue;
                for(int j = 0; j < t; j++) {
                    matrix[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return matrix;
    }
}
