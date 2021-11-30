public class _1043_PartitionArrayforMaximumSum {
    class Solution {
        public int maxSumAfterPartitioning(int[] arr, int k) {
            int n = arr.length;
            int[] dp = new int[n+1];
            for(int i = 1; i <= n; i++) {
                int max = Integer.MIN_VALUE;
                for(int j = i; j > Math.max(i-k, 0); j--) {
                    max = Math.max(max, arr[j-1]);
                    dp[i] = Math.max(dp[i], dp[j-1] + max*(i-j+1));
                }
            }
            return dp[n];
        }
    }
}
