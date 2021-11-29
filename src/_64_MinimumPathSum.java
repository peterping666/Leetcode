public class _64_MinimumPathSum {
    /**
     * Time O(m * n)
     * Space O(m * n)
     */
    class Solution1 {
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] dp = new int[m][n];
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(i == 0 && j == 0) {
                        dp[i][j] = grid[i][j];
                    } else if(i == 0) {
                        dp[i][j] = dp[i][j-1]+ grid[i][j];
                    } else if(j == 0) {
                        dp[i][j] = dp[i-1][j] + grid[i][j];
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
                    }
                }
            }
            return dp[m-1][n-1];
        }
    }

    /**
     * Time O(m * n)
     * Space O(n)
     */
    class Solution2 {
        public int minPathSum(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[] dp = new int[n];
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(i == 0 && j == 0) {
                        dp[j] = grid[i][j];
                    } else if(i == 0) {
                        dp[j] = dp[j-1] + grid[i][j];
                    } else if(j == 0) {
                        dp[j] += grid[i][j];
                    } else {
                        dp[j] = grid[i][j] + Math.min(dp[j-1], dp[j]);
                    }
                }
            }
            return dp[n-1];
        }
    }
}
