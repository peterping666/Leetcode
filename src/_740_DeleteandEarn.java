public class _740_DeleteandEarn {
    class Solution {
        public int deleteAndEarn(int[] nums) {
            int[] buckets = new int[10001];
            for (int num : nums) {
                buckets[num] += num;
            }
            int[] dp = new int[10001];
            dp[0] = buckets[0];
            dp[1] = buckets[1];
            for (int i = 2; i < buckets.length; i++) {
                dp[i] = Math.max(buckets[i] + dp[i - 2], dp[i - 1]);
            }
            return dp[10000];
        }
    }
}
