package Laicode;

public class _101_LargestSquareOf1s {
    public class Solution {
        public int largest(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] dp = new int[m][n];
            int max = 0;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(matrix[i][j] != 0) {
                        if(i == 0 || j == 0) {
                            dp[i][j] = 1;
                        } else {
                            dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                        }
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }
            return max;
        }
    }

}
