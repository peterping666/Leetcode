package Laicode;

import java.util.Arrays;

public class _116_ArrayDeduplicationII {
    public class Solution {
        public int[] dedup(int[] array) {
            if(array.length <= 2) {
                return array;
            }
            int slow = 2;
            for(int i = 2; i < array.length; i++) {
                if(array[i] != array[slow - 2]) {
                    array[slow++] = array[i];
                }
            }
            return Arrays.copyOf(array, slow);
        }
    }

}
