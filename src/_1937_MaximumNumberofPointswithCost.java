public class _1937_MaximumNumberofPointswithCost {
    class Solution {
        public long maxPoints(int[][] points) {
            int m = points.length, n = points[0].length;
            long[][] dp = new long[m][n];
            for(int j = 0; j < n; j++) {
                dp[0][j] = points[0][j];
            }
            for(int i = 1; i < m; i++) {
                long max = Integer.MIN_VALUE;
                for(int j = 0; j < n; j++) {
                    max = Math.max(max, dp[i-1][j] + j);
                    dp[i][j] = Math.max(dp[i][j], max + points[i][j] - j);
                }
                max = Integer.MIN_VALUE;
                for(int j = n-1; j >= 0; j--) {
                    max = Math.max(max, dp[i-1][j] - j);
                    dp[i][j] = Math.max(dp[i][j], max + points[i][j] + j);
                }
            }
            long res = 0;
            for(int j = 0; j < n; j++) {
                res = Math.max(res, dp[m-1][j]);
            }
            return res;
        }
    }
}
