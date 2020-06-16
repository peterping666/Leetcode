public class _367_ValidPerfectSquare {
    /**
     * Time O(logn)
     * Space O(1)
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            long product = (long)mid * mid;
            if(product == num) return true;
            else if(product < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
