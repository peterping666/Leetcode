package Laicode;

public class _97_LargestSubArraySum {
    public class Solution {
        public int largestSum(int[] array) {
            int maxSum = array[0];
            int[] dp = new int[array.length];
            dp[0] = array[0];
            for(int i = 1; i < array.length; i++) {
                dp[i] = Math.max(array[i], array[i] + dp[i - 1]);
                maxSum = Math.max(maxSum, dp[i]);
            }
            return maxSum;
        }
    }

}
