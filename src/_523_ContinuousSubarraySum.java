import java.util.HashMap;

public class _523_ContinuousSubarraySum {
    /** Key point: if we can find any two subarray of prefix sum have same mod value, then their difference MUST be
     * divisible by k. So we can use a map to store mod value of each prefix sum in map, with its index. Then check
     * if map contains the same mod value with size > 2 when we have new mod value in every iteration */
    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            int sum = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            for(int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if(k != 0) {
                    sum %= k;
                }
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

/*
    sum % 5
*/
}
