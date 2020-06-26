public class _70_ClimbingStairs {

    /**
     * Time O(n)
     * Space O(n)
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        return dfs(n, 0, new int[n]);
    }

    private int dfs(int n, int pos, int[] memo) {
        if(pos == n) {
            return 1;
        }
        if(pos > n) {
            return 0;
        }
        if(memo[pos] != 0) return memo[pos];
        memo[pos] = dfs(n, pos + 1, memo) + dfs(n, pos + 2, memo);
        return memo[pos];
    }

    /**
     * Time O(n)
     * Space O(n)
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[0] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /**
     * Time O(n)
     * Space O(1)
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        int first = 1;
        int second = 1;
        for(int i = 2; i <= n; i++) {
            int temp = second;
            second = first + second;
            first = temp;
        }
        return second;
    }
}
