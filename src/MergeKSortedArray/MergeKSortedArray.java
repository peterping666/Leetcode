package MergeKSortedArray;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedArray {
    class Solution {
        public List<Integer> mergeKSortedArray(int[][] arrs) {
            Queue<ArrayBucket> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.arr[a.index], b.arr[b.index]));
            for(int i = 0; i < arrs.length; i++) {
                if(arrs[i] != null && arrs[i].length > 0) {
                    minHeap.offer(new ArrayBucket(arrs[i], 0));
                }
            }
            List<Integer> res = new ArrayList<>();
            while(!minHeap.isEmpty()) {
                ArrayBucket cur = minHeap.poll();
                if(res.isEmpty() || res.get(res.size() - 1) != cur.arr[cur.index]) {
                    res.add(cur.arr[cur.index]);
                }
                if(++cur.index < cur.arr.length) {
                    minHeap.offer(cur);
                }
            }
            return res;
        }

        class ArrayBucket {
            int[] arr;
            int index;

            ArrayBucket(int[] a, int idx) {
                arr = a;
                index = idx;
            }
        }
    }
}
