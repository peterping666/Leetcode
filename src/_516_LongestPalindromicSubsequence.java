public class _516_LongestPalindromicSubsequence {
    class Solution {
        public int longestPalindromeSubseq(String s) {
            int n = s.length();
            int[][] dp = new int[n][n];
            for(int i = 0; i < n; i++) {
                dp[i][i] = 1;
                for(int j = i - 1; j >= 0; j--) {
                    if(s.charAt(j) == s.charAt(i)) {
                        dp[j][i] = dp[j+1][i-1] + 2;
                    } else {
                        dp[j][i] = Math.max(dp[j+1][i], dp[j][i-1]);
                    }
                }
            }
            return dp[0][n-1];
        }
    }
}
