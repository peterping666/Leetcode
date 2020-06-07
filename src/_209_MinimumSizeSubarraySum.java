public class _209_MinimumSizeSubarraySum {
    /**
     * Time O(n)
     * Space O(1)
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int ans = nums.length + 1;
        int left = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while(sum >= s) {
                ans = Math.min(ans, i - left + 1);
                sum -= nums[left++];
            }
        }
        return ans == nums.length + 1 ? 0 : ans;
    }
}
