public class _256_PaintHouse {
    /**
     * Time O(m * n)
     * Space O(m * n)
     * @param costs
     * @return
     */
    public int minCost1(int[][] costs) {
        int m = costs.length;
        int[][] dp = new int[m+1][3];
        for(int i = 0; i < m; i++) {
            dp[i+1][0] = Math.min(dp[i][1], dp[i][2]) + costs[i][0];
            dp[i+1][1] = Math.min(dp[i][0], dp[i][2]) + costs[i][1];
            dp[i+1][2] = Math.min(dp[i][0], dp[i][1]) + costs[i][2];
        }
        return Math.min(dp[m][0], Math.min(dp[m][1], dp[m][2]));
    }

    public int minCost2(int[][] costs) {
        int m = costs.length;
        int[] dp = new int[3];
        for(int i = 0; i < m; i++) {
            if(i == 0) {
                dp[0] = costs[i][0];
                dp[1] = costs[i][1];
                dp[2] = costs[i][2];
                continue;
            }
            int[] prevCosts = dp.clone();
            dp[0] = Math.min(prevCosts[1], prevCosts[2]) + costs[i][0];
            dp[1] = Math.min(prevCosts[0], prevCosts[2]) + costs[i][1];
            dp[2] = Math.min(prevCosts[0], prevCosts[1]) + costs[i][2];
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}
