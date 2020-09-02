package Laicode;

import java.util.*;

public class _182_2SumAllPairII {
    public class Solution {
        public List<List<Integer>> allPairs(int[] array, int target) {
            List<List<Integer>> res = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();
            for(int num : array) {
                Integer count = map.get(num);
                if(count == null && map.containsKey(target - num)) {
                    res.add(Arrays.asList(target - num, num));
                } else if(count != null && count == 1 && num + num == target) {
                    res.add(Arrays.asList(num, num));
                }
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            return res;
        }
    }

}
