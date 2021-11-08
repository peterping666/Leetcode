import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _494_TargetSum {

    class Solution2 {

        public int findTargetSumWays(int[] nums, int target) {
            Map<Map.Entry<Integer,Integer>,Integer> map = new HashMap<>();
            return dp(nums,target,0,0, map);
        }

        private int dp(int[] nums, int target, int index, int curSum, Map<Map.Entry<Integer,Integer>, Integer> map){
            Map.Entry<Integer,Integer> entry = Map.entry(index,curSum);
            if(map.containsKey(entry)) {
                return map.get(entry);
            }
            if(index == nums.length) {
                if(curSum == target) {
                    return 1;
                }
                return 0;
            }
            int pos = dp(nums, target,index + 1,curSum + nums[index], map);
            int neg = dp(nums, target,index + 1,curSum - nums[index], map);
            entry = Map.entry(index,curSum);
            map.put(entry,pos + neg);
            return pos + neg;
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
