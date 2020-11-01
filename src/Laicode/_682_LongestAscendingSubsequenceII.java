package Laicode;

public class _682_LongestAscendingSubsequenceII {
    public class Solution {
        public int[] longest(int[] a) {
            if(a.length == 0) {
                return new int[0];
            }
            int[][] dp = new int[a.length][2];
            dp[0][1] = 1;
            int longest = 1;
            int index = 0;
            for(int i = 1; i < a.length; i++) {
                int curLen = 1;
                int curIndex = i;
                for(int j = 0; j < i; j++) {
                    if(a[j] < a[i] && dp[j][1] >= curLen) {
                        curLen = dp[j][1] + 1;
                        curIndex = j;
                    }
                }
                dp[i][1] = curLen;
                dp[i][0] = index;
                if(curLen > longest) {
                    longest = curLen;
                    index = i;
                }
            }
            int[] res = new int[longest];
            for(int i = longest - 1; i >= 0; i--) {
                res[i] = a[index];
                index = dp[index][0];
            }
            return res;
        }
    }

}
