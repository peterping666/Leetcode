public class _544_OutputContestMatches {
    /**
     * Time O(n)
     * Space O(n)
     * @param n
     * @return
     */
    public String findContestMatch(int n) {
        String[] ans = new String[n];
        for(int i = 1; i <= n; i++) {
            ans[i-1] = i + "";
        }
        while(n > 1) {
            for(int i = 0; i < n / 2; i++) {
                ans[i] = "(" + ans[i] + "," + ans[n - i - 1] + ")";
            }
            n /= 2;
        }
        return ans[0];
    }
}
