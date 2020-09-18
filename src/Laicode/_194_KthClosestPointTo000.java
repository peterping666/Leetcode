package Laicode;

import java.util.*;

public class _194_KthClosestPointTo000 {
    public class Solution {
        public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
            Queue<List<Integer>> minHeap = new PriorityQueue<>(2 * k, new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> o1, List<Integer> o2) {
                    long d1 = distance(o1, a, b, c);
                    long d2 = distance(o2, a, b, c);
                    if(d1 == d2) {
                        return 0;
                    }
                    return d1 < d2 ? -1 : 1;
                }
            });
            Set<List<Integer>> visited = new HashSet<>();
            List<Integer> cur = Arrays.asList(0, 0, 0);
            visited.add(cur);
            minHeap.offer(cur);
            while(k > 0) {
                cur = minHeap.poll();
                List<Integer> n = Arrays.asList(cur.get(0) + 1, cur.get(1), cur.get(2));
                if(n.get(0) < a.length && visited.add(n)) {
                    minHeap.offer(n);
                }
                n = Arrays.asList(cur.get(0), cur.get(1) + 1, cur.get(2));
                if(n.get(1) < b.length && visited.add(n)) {
                    minHeap.offer(n);
                }
                n = Arrays.asList(cur.get(0), cur.get(1), cur.get(2) + 1);
                if(n.get(2) < c.length && visited.add(n)) {
                    minHeap.offer(n);
                }
                k--;
            }
            cur.set(0, a[cur.get(0)]);
            cur.set(1, b[cur.get(1)]);
            cur.set(2, c[cur.get(2)]);
            return cur;
        }

        public long distance(List<Integer> point, int[] a, int[] b, int[] c) {
            long dis = 0;
            dis += a[point.get(0)] * a[point.get(0)];
            dis += b[point.get(1)] * b[point.get(1)];
            dis += c[point.get(2)] * c[point.get(2)];
            return dis;
        }
    }

}
