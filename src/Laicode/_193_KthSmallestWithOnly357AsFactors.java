package Laicode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class _193_KthSmallestWithOnly357AsFactors {
    public class Solution {
        public long kth(int k) {
            Queue<Long> heap = new PriorityQueue<>();
            Set<Long> seen = new HashSet<>();

            heap.offer(3 * 5 * 7L);
            seen.add(3 * 5 * 7L);

            while(k > 1) {
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
                k--;
            }
            return heap.peek();
        }
    }
}
