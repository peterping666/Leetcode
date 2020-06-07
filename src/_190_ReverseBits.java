public class _190_ReverseBits {
    /**
     * Time O(1)
     * Space O(1)
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            ans <<= 1;
            ans += (n & 1);
            n >>= 1;
        }
        return ans;
    }
}
