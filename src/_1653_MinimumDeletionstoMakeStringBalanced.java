public class _1653_MinimumDeletionstoMakeStringBalanced {
    class Solution {
        public int minimumDeletions(String s) {
            int n = s.length();
            int[] left = new int[n];
            int[] right = new int[n];
            left[0] = s.charAt(0) == 'b' ? 1 : 0;
            for(int i = 1; i < n; i++) {
                left[i] = s.charAt(i) == 'b' ? left[i-1] + 1 : left[i-1];
            }
            right[n-1] = s.charAt(n-1) == 'a' ? 1 : 0;
            for(int i = n-2; i >= 0; i--) {
                right[i] = s.charAt(i) == 'a' ? right[i+1] + 1 : right[i+1];
            }
            int res = Math.min(right[0], left[n-1]);
            for(int i = 0; i < n-1; i++) {
                res = Math.min(res, left[i] + right[i+1]);
            }
            return res;
        }
    }
}
