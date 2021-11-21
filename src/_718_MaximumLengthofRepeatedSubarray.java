public class _718_MaximumLengthofRepeatedSubarray {
    class Solution {
        public int findLength(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int m = nums2.length;
            int[][] dp = new int[n+1][m+1];
            int res = 0;
            for(int i = n - 1; i >= 0; i--) {
                for(int j = m-1; j >= 0; j--) {
                    if(nums1[i] == nums2[j]) {
                        dp[i][j] = dp[i+1][j+1] + 1;
                    }
                    res = Math.max(res, dp[i][j]);
                }
            }
            return res;
        }
    }
}
