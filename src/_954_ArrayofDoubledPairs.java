import java.util.TreeMap;

public class _954_ArrayofDoubledPairs {
    class Solution {
        public boolean canReorderDoubled(int[] arr) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for(int num : arr) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for(int num : map.keySet()) {
                int countA = map.get(num);
                if(countA == 0) {
                    continue;
                }
                int want = num >= 0 ? num * 2 : num / 2;
                int countB = map.getOrDefault(want, 0);
                if(num < 0 && num % 2 != 0 || countB < countA) {
                    return false;
                }
                map.put(want, countB - countA);
                map.put(num, 0);
            }
            return true;
        }
    }
}
