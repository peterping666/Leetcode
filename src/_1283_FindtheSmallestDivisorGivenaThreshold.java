public class _1283_FindtheSmallestDivisorGivenaThreshold {
    class Solution {
        public int smallestDivisor(int[] nums, int threshold) {
            int max = 0;
            for(int num : nums) {
                max = Math.max(num, max);
            }
            int left = 1;
            int right = max;
            while(left < right) {
                int mid = left + (right - left) / 2;
                int curSum = 0;
                for(int num : nums) {
                    curSum += (num % mid == 0 ? num / mid : num / mid + 1);
                }
                if(curSum > threshold) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }
}
