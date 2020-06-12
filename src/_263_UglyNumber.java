public class _263_UglyNumber {
    /**
     * Time O(n)
     * Space O(1)
     * @param num
     * @return
     */
    public boolean isUgly(int num) {
        while(num > 0) {
            if(num == 1) return true;
            if(num % 2 == 0) {
                num /= 2;
            } else if(num % 3 == 0) {
                num /= 3;
            } else if(num % 5 == 0) {
                num /= 5;
            } else {
                return false;
            }
        }
        return false;
    }
}
