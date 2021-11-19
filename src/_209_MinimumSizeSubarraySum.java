public class _209_MinimumSizeSubarraySum {
    /**
     * Time O(n)
     * Space O(1)
     */
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int sum = 0, n = nums.length, res = n + 1;
            for(int i = 0, j = 0; i < n; i++) {
                sum += nums[i];
                while(sum >= target) {
                    res = Math.min(res, i - j + 1);
                    sum -= nums[j++];
                }
            }
            return res > n ? 0 : res;
        }
    }
}
