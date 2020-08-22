public class _221_MaximalSquare {
    /**
     * Time O(m * n)
     */
    class Solution {
        public int maximalSquare(char[][] matrix) {
            if(matrix.length == 0) {
                return 0;
            }
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] dp = new int[m][n];
            int maxLen = 0;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(matrix[i][j] == '1') {
                        if(i == 0 || j == 0) {
                            dp[i][j] = 1;
                        } else {
                            dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                        }
                        maxLen = Math.max(maxLen, dp[i][j]);
                    }
                }
            }
            return maxLen * maxLen;
        }
    }
}
