public class _829_ConsecutiveNumbersSum {
    class Solution {
        public int consecutiveNumbersSum(int n) {
            int res = 0;
            for(int i = 1; i * i + i < 2 * n; i++) {
                if((2 * n  - i * i + i) % (2 * i) == 0) {
                    res++;
                }
            }
            return res;
        }
    }
}
