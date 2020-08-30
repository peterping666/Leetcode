package Laicode;

import java.util.Arrays;

public class _115_ArrayDeduplicationI {
    public class Solution {
        public int[] dedup(int[] array) {
            if(array.length <= 1) {
                return array;
            }
            int slow = 1;
            for(int i = 1; i < array.length; i++) {
                if(array[i] != array[slow - 1]) {
                    array[slow++] = array[i];
                }
            }
            return Arrays.copyOf(array, slow);
        }
    }

}
