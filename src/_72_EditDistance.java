public class _72_EditDistance {
    /**
     * Time O(m * n)
     * Space O(m * n)
     */
    class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();
            int[][] dp = new int[m + 1][n + 1];
            // i represents the length of word1
            for(int i = 0; i <= m; i++) {
                // j represents the length of word2
                for(int j = 0; j <= n; j++) {
                    if(i == 0 || j == 0) {
                        dp[i][j] = i == 0 ? j : i;
                    } else if(word1.charAt(i - 1) != word2.charAt(j - 1)){
                        // dp[i-1][j-1] represents replacement
                        // dp[i-1][j] represents deletion
                        // dp[i][j-1] represents insertion
                        dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    } else{
                        dp[i][j] = dp[i-1][j-1];
                    }
                }
            }
            return dp[m][n];
        }
    }
}
