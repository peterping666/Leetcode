import java.util.HashMap;
import java.util.Map;

public class _532_KdiffPairsinanArray {
    /**
     * Time O(n)
     * Space O(n)
     * @param nums
     * @param k
     * @return
     */
    public int findPairs(int[] nums, int k) {
        if(k < 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(k == 0) {
                if(entry.getValue() >= 2) {
                    count++;
                }
            } else {
                if(map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }
        return count;
    }
}
