package Laicode;

import java.util.*;

public class _181_2SumAllPairI {
    public class Solution {
        public List<List<Integer>> allPairs(int[] array, int target) {
            List<List<Integer>> res = new ArrayList<>();
            Map<Integer, List<Integer>> map = new HashMap<>();
            for(int i = 0; i < array.length; i++) {
                if(map.containsKey(target - array[i])) {
                    for(int index : map.get(target - array[i])) {
                        res.add(Arrays.asList(index, i));
                    }
                }
                map.putIfAbsent(array[i], new ArrayList<>());
                map.get(array[i]).add(i);
            }
            return res;
        }
    }

}
