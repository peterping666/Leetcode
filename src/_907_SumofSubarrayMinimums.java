import java.util.ArrayDeque;
import java.util.Deque;

public class _907_SumofSubarrayMinimums {
    class Solution {
        public int sumSubarrayMins(int[] A) {
            Deque<int[]> prevLess = new ArrayDeque<>();
            Deque<int[]> nextLess = new ArrayDeque<>();
            int[] prevDist = new int[A.length];
            int[] nextDist = new int[A.length];

            for(int i = 0; i < A.length; i++) {
                while(!prevLess.isEmpty() && prevLess.peekFirst()[0] >= A[i]) {
                    prevLess.pollFirst();
                }
                prevDist[i] = prevLess.isEmpty() ? i+1 : i - prevLess.peekFirst()[1];
                prevLess.offerFirst(new int[]{A[i], i});
            }

            for(int i = A.length - 1; i >= 0; i--) {
                while(!nextLess.isEmpty() && nextLess.peekFirst()[0] > A[i]) {
                    nextLess.pollFirst();
                }
                nextDist[i] = nextLess.isEmpty() ? A.length - i : nextLess.peekFirst()[1] - i;
                nextLess.offerFirst(new int[]{A[i], i});
            }
            int res = 0;
            int modulus = (int)Math.pow(10, 9) + 7;
            for(int i = 0; i < A.length; i++) {
                res = (res + A[i] * prevDist[i] * nextDist[i]) % modulus;
            }
            return res;
        }
    }
}
