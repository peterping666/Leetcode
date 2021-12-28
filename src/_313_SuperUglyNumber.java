import java.util.PriorityQueue;
import java.util.Queue;

public class _313_SuperUglyNumber {

    /**
     * Time O(nlogk)
     */
    class Solution1 {
        public int nthSuperUglyNumber(int n, int[] primes) {
            int k = primes.length;
            Queue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
            for(int i = 0; i < k; i++) {
                heap.offer(new int[]{primes[i], 1, primes[i]});
            }
            int[] res = new int[n];
            res[0] = 1;
            for(int i = 1; i < n; i++) {
                res[i] = heap.peek()[0];
                while(res[i] == heap.peek()[0]) {
                    int[] next = heap.poll();
                    heap.offer(new int[]{next[2] * res[next[1]], next[1] + 1, next[2]});
                }
            }
            return res[n-1];
        }
    }

    /**
     * Time O(nk)
     */
    class Solution2 {
        public int nthSuperUglyNumber(int n, int[] primes) {
            int k = primes.length;
            int[] indices = new int[k];
            int[] res = new int[n];
            res[0] = 1;
            for(int i = 1; i < n; i++) {
                int next = Integer.MAX_VALUE;
                for(int j = 0; j < k; j++) {
                    next = Math.min(next, res[indices[j]] * primes[j]);
                }
                for(int j = 0; j < k; j++) {
                    if(next == res[indices[j]] * primes[j]) {
                        indices[j]++;
                    }
                }
                res[i] = next;
            }
            return res[n-1];
        }
    }
}
