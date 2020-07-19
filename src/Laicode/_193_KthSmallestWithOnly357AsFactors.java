package Laicode;

import java.util.HashSet;
import java.util.PriorityQueue;

public class _193_KthSmallestWithOnly357AsFactors {
    public class Solution {
        /**
         *
         * @param k
         * @return
         */
        public long kth(int k) {
            PriorityQueue<Long> heap = new PriorityQueue<>();
            HashSet<Long> seen = new HashSet<>();

            heap.offer(3 * 5 * 7L);
            seen.add(3 * 5 * 7L);

            while(k-- > 1) {
                long cur = heap.poll();
                if(seen.add(cur * 3)) {
                    heap.offer(cur * 3);
                }
                if(seen.add(cur * 5)) {
                    heap.offer(cur * 5);
                }
                if(seen.add(cur * 7)) {
                    heap.offer(cur * 7);
                }
            }
            return heap.peek();
        }
    }

}
