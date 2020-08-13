public class _53_MaximumSubarray {

    /**
     * Time O(n)
     * Space O(n)
     * @return
     */
    class Solution {
        public int maxSubArray(int[] nums) {
            int maxSum = nums[0];
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            for(int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(nums[i], nums[i] + dp[i-1]);
                maxSum = Math.max(maxSum, dp[i]);
            }
            return maxSum;
        }
    }

    /**
     * Time O(n)
     * Space O(1)
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int sum = nums[0];
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            res = Math.max(res, sum);
        }
        return res;
    }
}
