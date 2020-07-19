package Laicode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class _118_ArrayDeduplicationIV {
    public class Solution {
        public int[] dedup(int[] array) {
            Deque<Integer> deque = new ArrayDeque<>();
            for(int i = 0; i < array.length; i++) {
                if(deque.isEmpty() || array[i] != deque.peekLast()) {
                    deque.offerLast(array[i]);
                } else {
                    deque.pollLast();
                    while(i + 1 < array.length && array[i] == array[i + 1]) {
                        i++;
                    }
                }
            }
            int[] res = new int[deque.size()];
            for(int i = 0; i < res.length; i++) {
                res[i] = deque.pollFirst();
            }
            return res;
        }
    }

    /**
     *
     * @param array
     * @return
     */
    public int[] dedup(int[] array) {
        int end = 0;
        for(int i = 1; i < array.length; i++) {
            if(end == -1 || array[end] != array[i]) {
                array[++end] = array[i];
            } else {
                end--;
                while(i + 1 < array.length && array[i] == array[i + 1]) {
                    i++;
                }
            }
        }
        return Arrays.copyOf(array, end + 1);
    }
}
