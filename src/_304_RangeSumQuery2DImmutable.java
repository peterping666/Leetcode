public class _304_RangeSumQuery2DImmutable {
    class NumMatrix {
        /**
         * Time O(m * n)
         * Space O(m * n)
         */
        int[][] prefixSum;
        public NumMatrix(int[][] matrix) {
            if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
            int m = matrix.length;
            int n = matrix[0].length;
            prefixSum = new int[m + 1][n + 1];
            for(int i = 1; i <= m; i++) {
                for(int j = 1; j <= n; j++) {
                    prefixSum[i][j] = prefixSum[i][j-1] + prefixSum[i-1][j] - prefixSum[i-1][j-1] + matrix[i-1][j-1];
                }
            }
        }

        /**
         * Time O(1)
         * Space O(1)
         * @param row1
         * @param col1
         * @param row2
         * @param col2
         * @return
         */
        public int sumRegion(int row1, int col1, int row2, int col2) {
            return prefixSum[row2+1][col2+1] - prefixSum[row1][col2+1]
                    - prefixSum[row2+1][col1] + prefixSum[row1][col1];
        }
    }
}
