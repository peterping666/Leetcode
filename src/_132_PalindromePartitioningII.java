import java.util.Arrays;

public class _132_PalindromePartitioningII {
    /**
     * Time O(n^2)
     * Space O(n)
     */
    class Solution1 {
        public int minCut(String s) {
            int n = s.length();
            int[] dp = new int[n+1];
            for(int i = 0; i <= n; i++) {
                dp[i] = i-1;
            }
            for(int i = 0; i < n; i++) {
                for(int j = 0; j+i < n && i-j >= 0 && s.charAt(i-j) == s.charAt(i+j); j++) {
                    dp[i+j+1] = Math.min(dp[i+j+1], dp[i-j] + 1);
                }

                for(int j = 1; j+i < n && i-j+1 >= 0 && s.charAt(i-j+1) == s.charAt(i+j); j++) {
                    dp[i+j+1] = Math.min(dp[i+j+1], dp[i+1-j] + 1);
                }
            }
            return dp[n];
        }
    }

    /**
     * Time O(n^2)
     * Space O(n^2)
     */
    class Solution2 {
        public int minCut(String s) {
            int n = s.length();
            boolean[][] dp = new boolean[n][n];
            for(int len = 1; len <= n; len++) {
                for(int i = 0; i + len - 1 < n; i++) {
                    int j = i + len - 1;
                    if(s.charAt(i) == s.charAt(j)) {
                        if(i + 1 >= j - 1) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i+1][j-1];
                        }
                    }
                }
            }
            int[] res = new int[n];
            Arrays.fill(res, n);
            for(int i = 0; i < n; i++) {
                for(int j = 0; j <= i; j++) {
                    if(dp[j][i]) {
                        if(j == 0) {
                            res[i] = 1;
                        } else {
                            res[i] = Math.min(res[i], res[j-1] + 1);
                        }
                    }
                }
            }
            return res[n-1] - 1;
        }
    }
}
