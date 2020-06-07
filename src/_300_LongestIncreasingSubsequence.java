import java.util.Arrays;

public class _300_LongestIncreasingSubsequence {
    /**
     * Time O(n^2)
     * Space O(n)
     * @param nums
     * @return
     */
    public int lengthOfLIS1(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int max = 1;
        dp[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            int maxVal = 0;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    maxVal = Math.max(maxVal, dp[j]);
                }
            }
            dp[i] = maxVal + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * Time O(nlogn)
     * Space O(n)
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

}
