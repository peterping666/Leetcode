public class _312_BurstBalloons {
    class Solution {
        public int maxCoins(int[] nums) {
            int n = nums.length;
            int[] arr = new int[n + 2];
            arr[0] = 1;
            for(int i = 0; i < n; i++) {
                arr[i+1] = nums[i];
            }
            arr[n+1] = 1;

            int[][] dp = new int[n+2][n+2]; // maximum coins by bursting the balloons [i:j]
            for(int len = 1; len <= n; len++) {
                for(int i = 1; i + len - 1 <= n; i++) {
                    int j = i + len - 1;
                    for(int k = i; k <= j; k++) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][k-1] + arr[i-1] * arr[k] * arr[j+1] + dp[k+1][j]);
                    }
                }
            }
            return dp[1][n];
        }
    }
}
