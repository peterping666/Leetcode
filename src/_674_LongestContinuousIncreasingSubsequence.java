public class _674_LongestContinuousIncreasingSubsequence {
    /**
     * Time O(n)
     * Space O(1)
     * @param nums
     * @return
     */
    public int findLengthOfLCIS1(int[] nums) {
        if(nums.length == 0) return 0;
        int max = 1;
        int dp = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]) {
                dp++;
            } else {
                dp = 1;
            }
            max = Math.max(dp, max);
        }
        return max;
    }

    /**
     * Time O(n)
     * Space O(1)
     * @param nums
     * @return
     */
    public int findLengthOfLCIS2(int[] nums) {
        int max = 0, anchor = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] <= nums[i-1]) anchor = i;
            max = Math.max(i - anchor + 1, max);
        }
        return max;
    }
}
