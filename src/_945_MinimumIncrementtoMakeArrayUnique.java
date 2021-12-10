import java.util.Arrays;
import java.util.TreeMap;

public class _945_MinimumIncrementtoMakeArrayUnique {
    /**
     * Time O(nlogn)
     */
    class Solution {
        public int minIncrementForUnique(int[] nums) {
            Arrays.sort(nums);
            int res = 0, need = 0;
            for(int num : nums) {
                res += Math.max(0, need - num);
                need = Math.max(need, num) + 1;
            }
            return res;
        }
    }

    /**
     * Time O(n + klogk)
     */
    class Solution2 {
        public int minIncrementForUnique(int[] nums) {
            TreeMap<Integer, Integer> treemap = new TreeMap<>();
            for(int num : nums) {
                treemap.put(num, treemap.getOrDefault(num, 0) + 1);
            }
            int res = 0, need = 0;
            for(int num : treemap.keySet()) {
                int count = treemap.get(num);
                res += count * Math.max(0, need - num) + count * (count - 1) / 2;
                need = Math.max(need, num) + count;
            }
            return res;
        }
    }
}
