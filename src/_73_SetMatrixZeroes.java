public class _73_SetMatrixZeroes {
    class Solution {
        public void setZeroes(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            boolean zeroRow = false;
            boolean zeroCol = false;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                        if(i == 0) {
                            zeroRow = true;
                        }
                        if(j == 0) {
                            zeroCol = true;
                        }
                    }
                }
            }
            for(int i = 1; i < m; i++) {
                if(matrix[i][0] == 0) {
                    for(int j = 1; j < n; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }
            for(int j = 1; j < n; j++) {
                if(matrix[0][j] == 0) {
                    for(int i = 1; i < m; i++) {
                        matrix[i][j] = 0;
                    }
                }
            }
            if(zeroRow) {
                for(int i = 0; i < n; i++) {
                    matrix[0][i] = 0;
                }
            }
            if(zeroCol) {
                for(int i = 0; i < m; i++) {
                    matrix[i][0] = 0;
                }
            }
        }
    }
}
