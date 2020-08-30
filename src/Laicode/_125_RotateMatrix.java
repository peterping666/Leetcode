package Laicode;

public class _125_RotateMatrix {
    public class Solution1 {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            if(n <= 1) {
                return;
            }
            for(int i = 0; i < n / 2; i++) {
                for(int j = i; j < n - 1 - i; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n - 1 - j][i];
                    matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                    matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                    matrix[j][n - 1 - i] = temp;
                }
            }
        }
    }

    public class Solution2 {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            if(n <= 1) {
                return;
            }
            mirrorY(matrix, n);
            mirrorYEX(matrix, n);
        }

        // mirror the point by y axis
        private void mirrorY(int[][] matrix, int n) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n / 2; j++) {
                    swap(matrix, i, j, i, n - 1 - j);
                }
            }
        }

        // mirror the point by the line y = x
        private void mirrorYEX(int[][] matrix, int n) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n - 1 - i; j++) {
                    swap(matrix, i, j, n - 1 - j, n - 1 - i);
                }
            }
        }

        private void swap(int[][] matrix, int iRow, int iCol, int jRow, int jCol) {
            int temp = matrix[iRow][iCol];
            matrix[iRow][iCol] = matrix[jRow][jCol];
            matrix[jRow][jCol] = temp;
        }
    }

}

