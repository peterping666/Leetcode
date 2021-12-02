public class _1578_MinimumDeletionCosttoAvoidRepeatingLetters {

    /**
     * Time O(n)
     * Space O(1)
     */
    class Solution1 {
        public int minCost(String s, int[] cost) {
            int n = cost.length;
            int res = 0;
            int maxCost = cost[0];
            for(int i = 1; i < n; i++) {
                if(s.charAt(i) == s.charAt(i-1)) {
                    res += Math.min(cost[i], maxCost);
                    maxCost = Math.max(maxCost, cost[i]);
                } else {
                    maxCost = cost[i];
                }
            }
            return res;
        }
    }

    /**
     * Time O(n)
     * Space O(1)
     */
    class Solution2 {
        public int minCost(String s, int[] cost) {
            int n = cost.length;
            int dp = 0;
            for(int i = 1; i < n; i++) {
                if(s.charAt(i) == s.charAt(i-1)) {
                    dp += Math.min(cost[i], cost[i-1]);
                    cost[i] = Math.max(cost[i], cost[i-1]);
                }
            }
            return dp;
        }
    }

    /**
     * Time O(n)
     * Space O(n)
     */
    class Solution3 {
        public int minCost(String s, int[] cost) {
            int n = cost.length;
            int[] dp = new int[n];
            for(int i = 1; i < n; i++) {
                if(s.charAt(i) == s.charAt(i-1)) {
                    dp[i] = dp[i-1] + Math.min(cost[i], cost[i-1]);
                    cost[i] = Math.max(cost[i], cost[i-1]);
                } else {
                    dp[i] = dp[i-1];
                }
            }
            return dp[n-1];
        }
    }
}
