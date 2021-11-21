import java.util.HashMap;
import java.util.Map;

public class _532_KdiffPairsinanArray {

    class Solution {
        public int findPairs(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            int res = 0;
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(k == 0) {
                    if(entry.getValue() >= 2) {
                        res++;
                    }
                } else if(map.containsKey(entry.getKey() + k)) {
                    res++;
                }
            }
            return res;
        }
    }
}
