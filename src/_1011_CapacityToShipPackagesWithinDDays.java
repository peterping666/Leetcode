public class _1011_CapacityToShipPackagesWithinDDays {
    class Solution {
        public int shipWithinDays(int[] weights, int D) {
            int max = 0;
            int sum = 0;
            for(int weight : weights) {
                max = Math.max(max, weight);
                sum += weight;
            }
            int left = max;
            int right = sum;
            while(left < right) {
                int mid = left + (right - left) / 2;
                int days = 1;
                int curSum = 0;
                for(int w : weights) {
                    if(curSum + w > mid) {
                        curSum = 0;
                        days++;
                    }
                    curSum += w;
                }
                if(days > D) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }
}
