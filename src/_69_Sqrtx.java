public class _69_Sqrtx {
    /**
     * Time O(logn)
     * Space O(1)
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if(x < 2) return x;
        int left = 2, right = x / 2;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            long product = (long)mid * mid;
            if(product == x) return mid;
            if(product > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }


}
