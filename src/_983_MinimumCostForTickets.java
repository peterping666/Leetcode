public class _983_MinimumCostForTickets {
    class Solution {
        public int mincostTickets(int[] days, int[] costs) {
            int n = days[days.length-1];
            int[] dp = new int[n+1];
            for(int i = 1, j = 0; i <= n; i++) {
                if(i == days[j]) {
                    dp[i] = dp[i-1] + costs[0];
                    dp[i] = Math.min(dp[i],  dp[Math.max(i-7, 0)] + costs[1]);
                    dp[i] = Math.min(dp[i], dp[Math.max(i-30, 0)] + costs[2]);
                    j++;
                } else {
                    dp[i] = dp[i-1];
                }
            }
            return dp[n];
        }
    }
}
