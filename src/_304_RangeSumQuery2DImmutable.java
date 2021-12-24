public class _304_RangeSumQuery2DImmutable {
    class NumMatrix {

        private int[][] sum;

        public NumMatrix(int[][] matrix) {
            sum = new int[matrix.length][matrix[0].length];
            for(int i = 0; i < matrix.length; i++) {
                for(int j = 0; j < matrix[0].length; j++) {
                    if(i == 0 && j == 0) {
                        sum[i][j] = matrix[i][j];
                    } else if(i == 0) {
                        sum[i][j] = sum[i][j-1] + matrix[i][j];
                    } else if(j == 0) {
                        sum[i][j] = sum[i-1][j] + matrix[i][j];
                    } else {
                        sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + matrix[i][j];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int upSum = row1 > 0 ? sum[row1-1][col2] : 0;
            int leftSum = col1 > 0 ? sum[row2][col1-1] : 0;
            int leftUp = (row1 > 0 && col1 > 0) ? sum[row1-1][col1-1] : 0;
            return sum[row2][col2] - upSum - leftSum + leftUp;
        }
    }
}
