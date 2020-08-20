package Laicode;

public class _105_LargestXOf1s {
    public class Solution {
        public int largest(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] rightDown = rightDown(matrix, m, n);
            int[][] leftUp = leftUp(matrix, m, n);

            return merge(leftUp, rightDown, m, n);
        }

        private int merge(int[][] matrix1, int[][] matrix2, int m, int n) {
            int maxLen = 0;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    matrix1[i][j] = Math.min(matrix1[i][j], matrix2[i][j]);
                    maxLen = Math.max(maxLen, matrix1[i][j]);
                }
            }
            return maxLen;
        }

        private int[][] rightDown(int[][] matrix, int m, int n) {
            int[][] right = new int[m][n];
            int[][] down = new int[m][n];
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(matrix[i][j] == 1) {
                        right[i][j] = getNumber(right, i - 1, j - 1, m, n) + 1;
                        down[i][j] = getNumber(down, i - 1, j + 1, m, n) + 1;
                    }
                }
            }
            merge(right, down, m, n);
            return right;
        }

        private int getNumber(int[][] matrix, int i, int j, int m, int n) {
            if(i < 0 || j < 0 || i >= m || j >= n) {
                return 0;
            }
            return matrix[i][j];
        }

        private int[][] leftUp(int[][] matrix, int m, int n) {
            int[][] left = new int[m][n];
            int[][] up = new int[m][n];
            for(int i = m - 1; i >= 0; i--) {
                for(int j = n - 1; j >= 0; j--) {
                    if(matrix[i][j] == 1) {
                        left[i][j] = getNumber(left, i + 1, j + 1, m, n) + 1;
                        up[i][j] = getNumber(up, i + 1, j - 1, m, n) + 1;
                    }
                }
            }
            merge(left, up, m, n);
            return left;
        }
    }

}
