public class _70_ClimbingStairs {

    // Space: O(n)
    public int climbStairs1(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[0] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    // Space: O(1)
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
