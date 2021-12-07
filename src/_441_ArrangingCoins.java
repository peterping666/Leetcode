public class _441_ArrangingCoins {
    /**
     * Time O(logn)
     */
    class Solution1 {
        public int arrangeCoins(int n) {
            int left = 1, right = n;
            while(left < right) {
                int mid = right - (right - left) / 2;
                long cur = (long)(mid+1)*mid/2;
                if(cur <= n) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }

    /**
     * Time O(sqrt(n))
     */
    class Solution2 {
        public int arrangeCoins(int n) {
            int i=0;
            while(n >= 0){
                i++;
                n -= i;
            }
            return i-1;
        }
    }
}
