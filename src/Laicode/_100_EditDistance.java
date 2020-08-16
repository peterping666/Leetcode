package Laicode;

public class _100_EditDistance {
    public class Solution {
        public int editDistance(String one, String two) {
            int m = one.length();
            int n = two.length();
            int[][] dp = new int[m + 1][n + 1];
            for(int i = 0; i <= m; i++) {
                for(int j = 0; j <= n; j++) {
                    if(i == 0) {
                        dp[i][j] = j;
                    } else if(j == 0) {
                        dp[i][j] = i;
                    } else if(one.charAt(i - 1) == two.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    }
                }
            }
            return dp[m][n];
        }
    }

}
