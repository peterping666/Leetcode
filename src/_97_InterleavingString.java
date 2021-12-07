public class _97_InterleavingString {

    class Solution1 {
        public boolean isInterleave(String s1, String s2, String s3) {
            int m = s1.length(), n = s2.length();
            if(m+n != s3.length()) {
                return false;
            }
            boolean[][] dp = new boolean[m+1][n+1];
            dp[0][0] = true;
            for(int i = 0; i <= m; i++) {
                for(int j = 0; j <= n; j++) {
                    if(i > 0 && s1.charAt(i-1) == s3.charAt(i+j-1) && dp[i-1][j]) {
                        dp[i][j] = true;
                    } else if(j > 0 && s2.charAt(j-1) == s3.charAt(i+j-1) && dp[i][j-1]) {
                        dp[i][j] = true;
                    }
                }
            }
            return dp[m][n];
        }
    }

    class Solution2 {
        public boolean isInterleave(String s1, String s2, String s3) {
            int m = s1.length(), n = s2.length();
            if(m+n != s3.length()) {
                return false;
            }
            boolean[][] dp = new boolean[m+1][n+1];
            dp[0][0] = true;
            for(int i = 1; i <= m; i++) {
                dp[i][0] = s1.charAt(i-1) == s3.charAt(i-1) && dp[i-1][0];
            }
            for(int j = 1; j <= n; j++) {
                dp[0][j] = s2.charAt(j-1) == s3.charAt(j-1) && dp[0][j-1];
            }
            for(int i = 1; i <= m; i++) {
                for(int j = 1; j <= n; j++) {
                    if(s1.charAt(i-1) == s3.charAt(i+j-1) && dp[i-1][j]) {
                        dp[i][j] = true;
                    } else if(s2.charAt(j-1) == s3.charAt(i+j-1) && dp[i][j-1]) {
                        dp[i][j] = true;
                    }
                }
            }
            return dp[m][n];
        }
    }
}
