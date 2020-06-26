public class _63_UniquePathsII {
    /**
     * Time O(m * n)
     * Space O(m * n)
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if(obstacleGrid[0][0] == 1) return 0;
        dp[0][0] = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) continue;
                if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    if(i == 0) dp[i][j] = dp[i][j-1];
                    else if(j == 0) dp[i][j] = dp[i-1][j];
                    else dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * Time O(m * n)
     * Space O(n)
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[n];
        if(obstacleGrid[0][0] == 1) return 0;
        dp[0] = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) continue;
                if(obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if(j > 0) {
                    dp[j] += dp[j-1];
                }
            }
        }
        return dp[n-1];
    }
}
