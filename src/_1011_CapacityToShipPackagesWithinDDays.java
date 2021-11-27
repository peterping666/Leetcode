public class _1011_CapacityToShipPackagesWithinDDays {
    /**
     * Time O(nlog(sum(weights)))
     * Space O(n)
     */
    class Solution {
        public int shipWithinDays(int[] weights, int days) {
            int left = 0, right = 0;
            for(int weight : weights) {
                left = Math.max(left, weight);
                right += weight;
            }

            while(left < right) {
                int mid = left + (right - left) / 2;
                if(valid(weights, mid, days)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            return left;
        }

        private boolean valid(int[] weights, int max, int days) {
            int count = 0, sum = 0;
            for(int i = 0; i < weights.length - 1; i++) {
                sum += weights[i];
                if(sum + weights[i+1] > max) {
                    sum = 0;
                    count++;
                }
            }

            return count + 1 <= days;
        }
    }
}
