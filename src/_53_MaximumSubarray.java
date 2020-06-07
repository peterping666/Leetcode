public class _53_MaximumSubarray {

    /**
     * Time O(n)
     * Space O(n)
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int[] dp = new int[nums.length];
        int res = nums[0];
        dp[0] = nums[0];
        for(int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
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
