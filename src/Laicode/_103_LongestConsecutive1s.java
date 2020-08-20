package Laicode;

public class _103_LongestConsecutive1s {
    public class Solution1 {
        public int longest(int[] array) {
            if(array.length == 0) {
                return 0;
            }
            int[] dp = new int[array.length];
            dp[0] = array[0] == 1 ? 1 : 0;
            int maxLen = dp[0];
            for(int i = 1; i < array.length; i++) {
                dp[i] = array[i] == 1 ? dp[i - 1] + 1 : 0;
                maxLen = Math.max(maxLen, dp[i]);
            }
            return maxLen;
        }
    }

    public class Solution {
        public int longest(int[] array) {
            int cur = 0;;
            int maxLen = 0;
            for(int i = 0; i < array.length; i++) {
                if(array[i] == 1) {
                    if(i == 0 || array[i - 1] != 1) {
                        cur = 1;
                    } else{
                        cur++;
                    }
                    maxLen = Math.max(maxLen, cur);
                }
            }
            return maxLen;
        }
    }

}
