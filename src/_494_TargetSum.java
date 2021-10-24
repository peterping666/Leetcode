import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _494_TargetSum {

    /**
     * Time O(l * n) l is range of sum, n is size of nums
     * Space O(l * n)
     * @return
     */
    class Solution1 {
        public int findTargetSumWays(int[] nums, int target) {
            int[][] memo = new int[nums.length][2001];
            for(int[] row : memo) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
            return helper(nums, target, 0, memo, 0);
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


    class Solution2 {

        public int findTargetSumWays(int[] nums, int target) {
            Map<Map.Entry<Integer,Integer>,Integer> map = new HashMap<>();
            return dp(nums,target,nums.length-1,0, map);
        }

        private int dp(int[] nums, int target, int index, int curSum, Map<Map.Entry<Integer,Integer>, Integer> map){

            Map.Entry<Integer,Integer> entry = Map.entry(index,curSum);
            if(map.containsKey(entry)) return map.get(entry);

            if(index<0 && curSum==target) return 1;
            if(index<0) return 0;

            int pos = dp(nums,target,index-1,nums[index]+curSum, map);
            int neg = dp(nums,target,index-1,-nums[index]+curSum, map);

            entry = Map.entry(index,curSum);
            map.put(entry,pos+neg);

            return pos+neg;

        }
    }

    /**
     * Time O(2^n)
     * Space O(n)
     * @return
     */
    class Solution3 {
        public int findTargetSumWays(int[] nums, int target) {
            return helper(nums, target, 0);
        }

        private int helper(int[] nums, int S, int index) {
            if(index == nums.length) {
                return S == 0 ? 1 : 0;
            }
            return helper(nums, S - nums[index], index + 1) + helper(nums, S + nums[index], index + 1);
        }
    }
}
