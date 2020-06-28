public class _64_MinimumPathSum {
    /**
     * Time O(m * n)
     * Space O(m * n)
     * @param grid
     * @return
     */
    public int minPathSum1(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) {
                    continue;
                } else if(i == 0) {
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                } else if(j == 0) {
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * Time O(m * n)
     * Space O(n)
     * @param grid
     * @return
     */
    public int minPathSum2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) {
                    continue;
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
