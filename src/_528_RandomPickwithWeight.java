public class _528_RandomPickwithWeight {
    class Solution {

        private int[] prefixSums;
        private int totalSum;

        public Solution(int[] w) {
            this.prefixSums = new int[w.length];

            int prefixSum = 0;
            for (int i = 0; i < w.length; ++i) {
                prefixSum += w[i];
                this.prefixSums[i] = prefixSum;
            }
            this.totalSum = prefixSum;
        }

        public int pickIndex() {
            double target = this.totalSum * Math.random();

            // run a binary search to find the target zone
            int low = 0, high = prefixSums.length - 1;
            while (low < high) {
                // better to avoid the overflow
                int mid = low + (high - low) / 2;
                if (target > prefixSums[mid])
                    low = mid + 1;
                else
                    high = mid;
            }
            return low;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
}
