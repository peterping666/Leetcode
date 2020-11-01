package Laicode;

public class _1_LongestAscendingSubsequence {
    public class Solution {
        public int longest(int[] array) {
            if(array.length <= 1) {
                return array.length;
            }
            int[] dp = new int[array.length];
            dp[0] = 1;
            int longest = 1;
            for(int i = 1; i < array.length; i++) {
                int curLen = 1;
                for(int j = 0; j < i; j++) {
                    if(array[j] < array[i] && dp[j] >= curLen) {
                        curLen = dp[j] + 1;
                    }
                }
                dp[i] = curLen;
                if(curLen > longest) {
                    longest = curLen;
                }
            }
            return longest;
        }
    }

}
