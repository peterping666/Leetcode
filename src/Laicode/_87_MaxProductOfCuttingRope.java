package Laicode;

public class _87_MaxProductOfCuttingRope {
    public class Solution {
        public int maxProduct(int length) {
            int[] dp = new int[length + 1];
            for(int i = 2; i <= length; i++) {
                for(int j = 1; j < i; j++) {
                    dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * (i - j));
                }
            }
            return dp[length];
        }
    }

}
