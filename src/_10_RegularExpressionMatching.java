public class _10_RegularExpressionMatching {
    class Solution {
        public boolean isMatch(String s, String p) {
            int m = s.length();
            int n = p.length();
            boolean[][] dp = new boolean[m+1][n+1];
            dp[0][0] = true;

            for(int i = 2; i <= n; i+=2) {
                dp[0][i] = p.charAt(i-1) == '*' && dp[0][i-2];
            }

            for(int i = 1; i <= m; i++) {
                for(int j = 1; j <= n; j++) {
                    if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
                        dp[i][j] = dp[i-1][j-1];
                    } else if(p.charAt(j-1) == '*') {
                        boolean notZero = (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') && dp[i-1][j];
                        boolean zero = dp[i][j-2];
                        dp[i][j] = notZero || zero;
                    }
                }
            }
            return dp[m][n];
        }
    }
}
