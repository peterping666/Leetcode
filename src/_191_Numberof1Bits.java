public class _191_Numberof1Bits {
    /**
     * Time O(1)
     * Space O(1)
     * @param n
     * @return
     */
    public int hammingWeight1(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++) {
            count += (n & 1);
            n >>= 1;
        }
        return count;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        while(n != 0) {
            n &= (n-1);
            count++;
        }
        return count;
    }
}
