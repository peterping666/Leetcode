import java.util.HashMap;

public class _523_ContinuousSubarraySum {

    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            int sum = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            for(int i = 0; i < nums.length; i++) {
                sum = (sum + nums[i]) % k;
                if(map.containsKey(sum)) {
                    if(i - map.get(sum) > 1) {
                        return true;
                    }
                } else {
                    map.put(sum, i);
                }
            }
            return false;
        }
    }
}
