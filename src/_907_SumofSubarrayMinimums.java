import java.util.ArrayDeque;
import java.util.Deque;

public class _907_SumofSubarrayMinimums {
    class Solution {
        public int sumSubarrayMins(int[] arr) {
            int n = arr.length;
            Deque<Integer> stack = new ArrayDeque<>();

            int[] left = new int[n];
            for(int i = 0; i < n; i++) {
                while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                    stack.pop();
                }
                left[i] = stack.isEmpty() ? i + 1: i - stack.peek();
                stack.push(i);
            }

            stack.clear();

            int[] right = new int[n];
            for(int i = n - 1; i >= 0; i--) {
                while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                    stack.pop();
                }
                right[i] = stack.isEmpty() ? n - i : stack.peek() - i;
                stack.push(i);
            }

            long res = 0;
            long mod = (long)1e9+7;
            for(int i = 0; i < n; i++) {
                res = (res + (long)arr[i] * left[i] * right[i]) % mod;
            }
            return (int)res;
        }
    }
}
