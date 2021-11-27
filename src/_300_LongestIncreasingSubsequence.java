public class _300_LongestIncreasingSubsequence {

    /**
     * Time O(nlogn)
     * Space O(n)
     */
    class Solution1 {
        public int lengthOfLIS(int[] nums) {
            int[] lis = new int[nums.length];
            int size = 0;
            for (int num : nums) {
                int index = helper(lis, size, num);
                lis[index] = num;
                if (index == size) {
                    size++;
                }
            }
            return size;
        }

        private int helper(int[] lis, int size, int target) {
            int left = 0, right = size;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (lis[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }

    /**
     * Time: O(n^2)
     */
    class Solution2 {
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            int res = 0;
            for(int i = 0; i < nums.length; i++) {
                dp[i] = 1;
                for(int j = 0; j < i; j++) {
                    if(nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }
}
