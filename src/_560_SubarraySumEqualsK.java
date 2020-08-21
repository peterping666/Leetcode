import java.util.HashMap;
import java.util.Map;

public class _560_SubarraySumEqualsK {

    /**
     * Time O(n)
     * Space O(n)
     */
    class Solution3 {
        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> prefixSum = new HashMap<>();
            prefixSum.put(0, 1);
            int sum = 0;
            int count = 0;
            for(int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if(prefixSum.containsKey(sum - k)) {
                    count += prefixSum.get(sum - k);
                }
                prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
            }
            return count;
        }
    }
}
