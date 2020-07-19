package Laicode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _204_MaximumValuesOfSizeKSlidingWindows {
    public class Solution {
        /**
         *
         * @param array
         * @param k
         * @return
         */
        public List<Integer> maxWindows(int[] array, int k) {
            List<Integer> list = new ArrayList<>();
            Deque<int[]> deque = new ArrayDeque<>();
            for(int i = 0; i < array.length; i++) {
                int num = array[i];
                while(!deque.isEmpty() && deque.peekLast()[0] <= num) {
                    deque.pollLast();
                }
                deque.offerLast(new int[]{num, i});

                if(i - deque.peekFirst()[1] == k) {
                    deque.pollFirst();
                }
                if(i >= k - 1) {
                    list.add(deque.peekFirst()[0]);
                }
            }
            return list;
        }
    }

    /**
     *
     * @param array
     * @param k
     * @return
     */
    public List<Integer> maxWindows(int[] array, int k) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < array.length; i++) {
            int num = array[i];
            while(!deque.isEmpty() && array[deque.peekLast()] <= num) {
                deque.pollLast();
            }
            deque.offerLast(i);

            if(i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }
            if(i >= k - 1) {
                list.add(array[deque.peekFirst()]);
            }
        }
        return list;
    }

}
