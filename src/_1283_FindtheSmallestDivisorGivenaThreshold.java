public class _1283_FindtheSmallestDivisorGivenaThreshold {
    /**
     * Time O(nlog(max))
     */
    class Solution {
        public int smallestDivisor(int[] nums, int threshold) {
            int left = 1;
            int max = 0;
            for(int num : nums) {
                max = Math.max(num, max);
            }
            int right = max;
            while(left < right) {
                int mid = left + (right - left) / 2;
                if(valid(nums, mid, threshold)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private boolean valid(int[] nums, int divisor, int threshold) {
            int sum = 0;
            for(int num : nums) {
                sum += (num % divisor == 0 ? num / divisor : num / divisor + 1);
                if(sum > threshold) {
                    return false;
                }
            }
            return true;
        }
    }
}
