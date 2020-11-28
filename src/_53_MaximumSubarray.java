public class _53_MaximumSubarray {

    /**
     * Time O(n)
     * Space O(n)
     */
    class Solution1 {
        public int maxSubArray(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            int maxSum = nums[0];
            for(int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(nums[i], nums[i] + dp[i-1]);
                maxSum = Math.max(maxSum, dp[i]);
            }
            return maxSum;
        }
    }

    /**
     * Time O(n)
     * Space O(1) Optimization
     */
    class Solution2 {
        public int maxSubArray(int[] nums) {
            int sum = nums[0];
            int max = nums[0];
            for(int i = 1; i < nums.length; i++) {
                sum = Math.max(nums[i], sum + nums[i]);
                max = Math.max(max, sum);
            }
            return max;
        }
    }
}
