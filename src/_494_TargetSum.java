import java.util.Arrays;

public class _494_TargetSum {
    /**
     * Time O(2^n)
     * Space O(n)
     * @return
     */
    class Solution {
        public int findTargetSumWays(int[] nums, int S) {
            return helper(nums, S, 0);
        }

        private int helper(int[] nums, int S, int index) {
            if(index == nums.length) {
                return S == 0 ? 1 : 0;
            }
            return helper(nums, S - nums[index], index + 1) + helper(nums, S + nums[index], index + 1);
        }
    }

    /**
     * Time O(l * n) l is range of sum, n is size of nums
     * Space O(l * n)
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays2(int[] nums, int S) {
        int[][] memo = new int[nums.length][2001];
        for(int[] row : memo) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        return helper(nums, S, 0, memo, 0);
    }

    private int helper(int[] nums, int S, int idx, int[][] memo, int sum) {
        if(idx == nums.length) {
            if(S == sum) {
                return 1;
            }
            return 0;
        }
        if(memo[idx][sum + 1000] != Integer.MAX_VALUE) return memo[idx][sum + 1000];
        memo[idx][sum + 1000] = helper(nums, S, idx + 1, memo, sum - nums[idx])
                + helper(nums, S, idx + 1, memo, sum + nums[idx]);
        return memo[idx][sum + 1000];
    }
}
