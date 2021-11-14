import java.util.HashMap;
import java.util.Map;

public class _1481_LeastNumberofUniqueIntegersafterKRemovals {
    class Solution {
        public int findLeastNumOfUniqueInts(int[] arr, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int num : arr) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            int[] count = new int[arr.length + 1];
            for(int val : map.values()) {
                count[val]++;
            }
            int res = map.size();
            for(int freq = 0; freq < count.length; freq++) {
                if(count[freq] > 0) {
                    if(k > count[freq] * freq) {
                        res -= count[freq];
                        k -= count[freq] * freq;
                    } else {
                        res -= k / freq;
                        break;
                    }
                }
            }
            return res;
        }
    }
}
