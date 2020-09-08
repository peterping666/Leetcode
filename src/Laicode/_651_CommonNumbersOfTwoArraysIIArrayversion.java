package Laicode;

import java.util.*;

public class _651_CommonNumbersOfTwoArraysIIArrayversion {
    public class Solution {
        public List<Integer> common(int[] A, int[] B) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int num : A) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            List<Integer> res = new ArrayList<>();
            for(int num : B) {
                if(map.containsKey(num) && map.get(num) > 0) {
                    res.add(num);
                    map.put(num, map.get(num) - 1);
                }
            }
            Collections.sort(res);
            return res;
        }
    }

}
