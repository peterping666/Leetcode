public class _152_MaximumProductSubarray {
    /**
     * Time O(n)
     * Space O(1)
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int max = nums[0];
        int min = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            min = Math.min(nums[i], Math.min(temp * nums[i], min * nums[i]));
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
