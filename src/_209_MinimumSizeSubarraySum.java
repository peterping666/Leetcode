public class _209_MinimumSizeSubarraySum {
    /**
     * Time O(n)
     * Space O(1)
     * @return
     */
    class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            int ans = nums.length + 1;
            int sum = 0;
            for(int i = 0, j = 0; i < nums.length; i++) {
                sum += nums[i];
                while(sum >= s) {
                    ans = Math.min(ans, i - j + 1);
                    sum -= nums[j++];
                }
            }
            return ans == nums.length + 1 ? 0 : ans;
        }
    }
}
