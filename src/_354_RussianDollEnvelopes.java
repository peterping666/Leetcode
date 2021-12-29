import java.util.Arrays;

public class _354_RussianDollEnvelopes {

    /**
     * Time O(nlogn)
     * Space O(n)
     */
    class Solution1 {
        public int maxEnvelopes(int[][] envelopes) {
            Arrays.sort(envelopes, (a,b) -> a[0] == b[0] ?
                    Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));

            int n = envelopes.length, res = 0;
            int[] arr = new int[n];
            for(int[] envelope : envelopes) {
                int index = helper(arr, res, envelope[1]);
                arr[index] = envelope[1];
                if(index == res) {
                    res++;
                }
            }
            return res;
        }

        private int helper(int[] arr, int size, int target) {
            int left = 0, right = size;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }

    /**
     * Time O(n^2)
     * Space O(n)
     */
    class Solution2 {
        public int maxEnvelopes(int[][] envelopes) {
            Arrays.sort(envelopes, (a, b) -> Integer.compare(a[0], b[0]));
            int n = envelopes.length, res = 0;
            int[] dp = new int[n];
            for(int i = 0; i < n; i++) {
                int w = envelopes[i][0];
                int h = envelopes[i][1];
                dp[i] = 1;
                for(int j = i-1; j >= 0; j--) {
                    if(w > envelopes[j][0] && h > envelopes[j][1]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }
}
