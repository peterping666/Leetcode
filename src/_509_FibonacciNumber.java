public class _509_FibonacciNumber {
    /**
     * Time O(n)
     * Space O(n)
     * @param N
     * @return
     */
    public int fib1(int N) {
        if(N == 0) return 0;
        int[] dp = new int[N+1];
        dp[1] = 1;
        for(int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[N];
    }

    /**
     * Time O(n)
     * Space O(1)
     * @param N
     * @return
     */
    public int fib2(int N) {
        if(N == 0) return 0;
        int dp1 = 0, dp2 = 1;
        for(int i = 2; i <= N; i++) {
            int tmp = dp2;
            dp2 = dp2 + dp1;
            dp1 = tmp;
        }
        return dp2;
    }
}
