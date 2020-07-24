public class _774_MinimizeMaxDistancetoGasStation {
    class Solution {
        public double minmaxGasDist(int[] stations, int K) {
            int n = stations.length;
            double left = 0;
            double right = stations[n - 1] - stations[0];
            while(left + 1e-6 < right) {
                double mid = left + (right - left) / 2;
                int count = 0;
                for(int i = 0; i < n-1; i++) {
                    int diff = stations[i+1] - stations[i];
                    count += diff % mid == 0 ? diff / mid - 1 : diff / mid;
                }
                if(count > K) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }
}
