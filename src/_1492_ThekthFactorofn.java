public class _1492_ThekthFactorofn {
    class Solution {
        public int kthFactor(int n, int k) {
            double root = Math.sqrt((double)n);

            for (int i = 1; i < root; i++) {
                if (n % i == 0 && --k == 0) {
                    return i;
                }
            }

            for (int i = (int)root; i >= 1; i--) {
                if (n % i == 0 && --k == 0) {
                    return n / i;
                }
            }

            return -1;
        }
    }
}
