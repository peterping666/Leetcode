public class _926_FlipStringtoMonotoneIncreasing {
    class Solution {
        public int minFlipsMonoIncr(String s) {
            int n = s.length();
            int[][] dp = new int[n+1][2];

            for(int i = 1; i <= n; i++) {
                if(s.charAt(i-1) == '0') {
                    dp[i][0] = dp[i-1][0];
                    dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1]) + 1;
                } else {
                    dp[i][0] = dp[i-1][0] + 1;
                    dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1]);
                }
            }
            return Math.min(dp[n][0], dp[n][1]);
        }
    }
}
