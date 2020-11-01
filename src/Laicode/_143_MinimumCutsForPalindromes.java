package Laicode;

import java.util.Arrays;

public class _143_MinimumCutsForPalindromes {
    public class Solution {
        public int minCuts(String input) {
            if(input.length() <= 1) {
                return 0;
            }
            int n = input.length() + 1;
            int[] dp = new int[n];
            Arrays.fill(dp, n);
            dp[0] = -1;
            dp[1] = 0;
            for(int i = 2; i < n; i++) {
                for(int j = 0; j < i; j++) {
                    if(isPalindrome(input, j, i - 1)) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
            return dp[n - 1];
        }
        private boolean isPalindrome(String input, int left, int right) {
            while(left < right) {
                if(input.charAt(left) != input.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }

}
