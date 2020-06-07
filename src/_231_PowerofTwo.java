public class _231_PowerofTwo {
    /**
     * Time O(1)
     * Space O(1)
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n - 1) == 0;
    }
}
