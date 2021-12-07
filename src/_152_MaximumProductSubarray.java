public class _152_MaximumProductSubarray {
    /**
     * Time O(n)
     * Space O(1)
     */
    class Solution {
        public int maxProduct(int[] nums) {
            int res = nums[0], max = nums[0], min = nums[0];
            for(int i = 1; i < nums.length; i++) {
                int temp = max;
                max = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
                min = Math.min(nums[i], Math.min(temp * nums[i], min * nums[i]));
                res = Math.max(res, max);
            }
            return res;
        }
    }
}
