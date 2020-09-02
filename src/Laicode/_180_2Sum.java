package Laicode;

import java.util.HashSet;
import java.util.Set;

public class _180_2Sum {
    public class Solution {
        public boolean existSum(int[] array, int target) {
            Set<Integer> set = new HashSet<>();
            for(int num : array) {
                if(set.contains(num)) {
                    return true;
                }
                set.add(target - num);
            }
            return false;
        }
    }

}
