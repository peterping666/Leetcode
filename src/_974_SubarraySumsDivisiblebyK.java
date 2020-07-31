import java.util.HashMap;
import java.util.Map;

public class _974_SubarraySumsDivisiblebyK {
    class Solution1 {
        public int subarraysDivByK(int[] A, int K) {
            Map<Integer, Integer> prefixSum = new HashMap<>();
            prefixSum.put(0, 1);
            int sum = 0;
            int res = 0;
            for(int a : A) {
                sum = (sum + a) % K;
                if(sum < 0) {
                    sum += K;
                }
                if(prefixSum.containsKey(sum)) {
                    res += prefixSum.get(sum);
                }
                prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
            }
            return res;
        }
    }

    class Solution2 {
        public int subarraysDivByK(int[] A, int K) {
            int[] map = new int[K];
            map[0]++;
            int sum = 0;
            int res = 0;
            for(int a : A) {
                sum = (sum + a) % K;
                if(sum < 0) {
                    sum += K;
                }
                res += map[sum];
                map[sum]++;
            }
            return res;
        }
    }
}
