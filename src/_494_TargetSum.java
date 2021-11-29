import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class _494_TargetSum {

    /**
     * Time O(n * sum(nums))
     */
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            return helper(nums, target, 0, new HashMap<>());
        }

        private int helper(int[] nums, int target, int index, Map<Pair<Integer,Integer>, Integer> map){
            if(index == nums.length) {
                return target == 0 ? 1 : 0;
            }
            Pair<Integer, Integer> pair = new Pair(index, target);

            if(map.containsKey(pair)) {
                return map.get(pair);
            }
            int res = 0;
            res += helper(nums, target + nums[index], index + 1, map);
            res += helper(nums, target - nums[index], index + 1, map);
            map.put(pair, res);
            return res;
        }
    }
}
