import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class _768_MaxChunksToMakeSortedII {

    class Solution1 {
        public int maxChunksToSorted(int[] arr) {
            int n = arr.length;
            int[] minOfRight = new int[n];
            minOfRight[n - 1] = arr[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                minOfRight[i] = Math.min(minOfRight[i + 1], arr[i]);
            }
            int res = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n - 1; i++) {
                max = Math.max(max,arr[i]);
                if (max <= minOfRight[i + 1]) res++;
            }
            return res + 1;
        }
    }

    class Solution2 {
        public int maxChunksToSorted(int[] arr) {
            Deque<Integer> stack = new ArrayDeque<>();
            int max = -1;
            for(int num : arr) {
                max = Math.max(max, num);
                while(!stack.isEmpty() && stack.peek() > num) {
                    max = Math.max(max, stack.pop());
                }
                stack.push(max);
            }
            return stack.size();
        }
    }

    class Solution3 {
        public int maxChunksToSorted(int[] arr) {
            int n = arr.length;
            int[] sorted = Arrays.copyOf(arr, n);
            Arrays.sort(sorted);
            int sum1 = 0, sum2 = 0, res = 0;
            for(int i = 0; i < n; i++) {
                sum1 += sorted[i];
                sum2 += arr[i];
                if(sum1 == sum2) {
                    res++;
                    sum1 = 0;
                    sum2 = 0;
                }
            }
            return res;
        }
    }
}
