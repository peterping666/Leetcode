public class _69_Sqrtx {
    /**
     * Time O(logn)
     * Space O(1)
     */
    class Solution {
        public int mySqrt(int x) {
            long left = 0, right = x;
            while(left < right) {
                long mid = right - (right - left) / 2;
                if(mid * mid > x) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
            return (int)left;
        }
    }
}
