package Laicode;

import java.util.Arrays;

public class _117_ArrayDeduplicationIII {
    public class Solution {
        public int[] dedup(int[] array) {
            int slow = 0;
            for(int i = 0; i < array.length; i++) {
                int len = 1;
                while(i + 1 < array.length && array[i] == array[i + 1]) {
                    i++;
                    len++;
                }
                if(len == 1) {
                    array[slow++] = array[i];
                }
            }
            return Arrays.copyOf(array, slow);
        }
    }

}
