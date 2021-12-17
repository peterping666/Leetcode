public class _91_DecodeWays {
    /**
     * Time O(n)
     * Space O(n)
     */
    class Solution {
        public int numDecodings(String s) {
            int[] dp = new int[s.length() + 1];
            dp[0] = 1;
            dp[1] = s.charAt(0) == '0' ? 0 : 1;
            for(int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c >= '1' && c <= '9') {
                    dp[i + 1] += dp[i];
                }
                int num = c - '0' + (s.charAt(i - 1) - '0') * 10;
                if(num >= 10 && num <= 26) {
                    dp[i + 1] += dp[i - 1];
                }
            }
            return dp[s.length()];
        }
    }
}
