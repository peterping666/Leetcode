import java.util.PriorityQueue;
import java.util.Queue;

public class _264_UglyNumberII {
    /**
     * Time O(n)
     */
    class Solution {
        public int nthUglyNumber(int n) {
            int[] res = new int[n];
            res[0] = 1;
            for(int i = 1, idx2 = 0, idx3 = 0, idx5 = 0; i < n; i++) {
                int next = Math.min(res[idx2] * 2, Math.min(res[idx3] * 3, res[idx5] * 5));
                if(next == res[idx2] * 2) {
                    idx2++;
                }
                if(next == res[idx3] * 3) {
                    idx3++;
                }
                if(next == res[idx5] * 5) {
                    idx5++;
                }
                res[i] = next;
            }
            return res[n-1];
        }
    }

    /**
     * Time O(nlogn)
     */
    class Solution2 {
        public int nthUglyNumber(int n) {
            Queue<Long> heap = new PriorityQueue<>();
            heap.offer((long)1);
            while(--n > 0) {
                long cur = heap.poll();
                while(!heap.isEmpty() && cur == heap.peek()) {
                    heap.poll();
                }
                heap.offer(cur * 2);
                heap.offer(cur * 3);
                heap.offer(cur * 5);
            }
            long res = heap.peek();
            return (int)res;
        }
    }
}
