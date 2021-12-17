public class _486_PredicttheWinner {

    class Solution1 {
        public boolean PredictTheWinner(int[] nums) {
            int n = nums.length, sum = 0;
            int[][] dp = new int[n][n];
            for(int i = 0; i < n; i++) {
                dp[i][i] = nums[i];
                sum += nums[i];
            }
            for(int i = 0; i < n-1; i++) {
                dp[i][i+1] = Math.max(nums[i], nums[i+1]);
            }
            for(int i = n-3; i >= 0; i--) {
                for(int j = i+2; j < n; j++) {
                    int left = Math.min(dp[i+1][j-1], dp[i+2][j]) + nums[i];
                    int right = Math.min(dp[i][j-2], dp[i+1][j-1]) + nums[j];
                    dp[i][j] = Math.max(left, right);
                }
            }
            return 2 * dp[0][n-1] >= sum;
        }
    }

    class Solution2 {
        public boolean PredictTheWinner(int[] nums) {
            int n = nums.length, sum = 0;
            int[][] dp = new int[n][n];
            for(int i = 0; i < n; i++) {
                dp[i][i] = nums[i];
                sum += nums[i];
            }
            for(int i = 0; i < n-1; i++) {
                dp[i][i+1] = Math.max(nums[i], nums[i+1]);
            }
            for(int l = 3; l <= n; l++) {
                for(int i = 0; i + l - 1 < n; i++) {
                    int j = i + l - 1;
                    int left = Math.min(dp[i+1][j-1], dp[i+2][j]) + nums[i];
                    int right = Math.min(dp[i][j-2], dp[i+1][j-1]) + nums[j];
                    dp[i][j] = Math.max(left, right);
                }
            }
            return 2 * dp[0][n-1] >= sum;
        }
    }
}
