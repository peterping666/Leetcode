package Laicode;

public class _104_LongestCrossOf1s {
    /**
     * Time O(m * n)
     * Space O(m * n)
     */
    public class Solution1 {
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
                        right[i][j] = getNumber(right, i, j - 1, m, n) + 1;
                        down[i][j] = getNumber(down, i - 1, j, m, n) + 1;
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
                        left[i][j] = getNumber(left, i, j + 1, m, n) + 1;
                        up[i][j] = getNumber(up, i + 1, j, m, n) + 1;
                    }
                }
            }
            merge(left, up, m, n);
            return left;
        }
    }


    /**
     * Time O(m * n)
     * Space O(m * n)
     */
    public class Solution2 {
        public int largest(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] right = new int[m][n];
            int[][] left = new int[m][n];
            int[][] up = new int[m][n];
            int[][] down = new int[m][n];

            // right
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(matrix[i][j] == 1) {
                        if(j == 0 || matrix[i][j - 1] == 0) {
                            right[i][j] = 1;
                        } else {
                            right[i][j] = right[i][j - 1] + 1;
                        }
                    }
                }
            }
            // left
            for(int i = 0; i < m; i++) {
                for(int j = n - 1; j >= 0; j--) {
                    if(matrix[i][j] == 1) {
                        if(j == n - 1 || matrix[i][j + 1] == 0) {
                            left[i][j] = 1;
                        } else {
                            left[i][j] = left[i][j + 1] + 1;
                        }
                    }
                }
            }
            // down
            for(int j = 0; j < n; j++) {
                for(int i = 0; i < m; i++) {
                    if(matrix[i][j] == 1) {
                        if(i == 0 || matrix[i - 1][j] == 0) {
                            down[i][j] = 1;
                        } else {
                            down[i][j] = down[i - 1][j] + 1;
                        }
                    }
                }
            }
            // up
            for(int j = 0; j < n; j++) {
                for(int i = m - 1; i >= 0; i--) {
                    if(matrix[i][j] == 1) {
                        if(i == m - 1 || matrix[i + 1][j] == 0) {
                            up[i][j] = 1;
                        } else {
                            up[i][j] = up[i + 1][j] + 1;
                        }
                    }
                }
            }
            int maxLen = 0;
            for(int j = 0; j < n; j++) {
                for(int i = m - 1; i >= 0; i--) {
                    if(matrix[i][j] == 1) {
                        int cur = Math.min(down[i][j] , Math.min(up[i][j], Math.min(left[i][j], right[i][j])));
                        maxLen = Math.max(maxLen, cur);
                    }
                }
            }
            return maxLen;
        }
    }

}
