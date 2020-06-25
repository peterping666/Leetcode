public class _342_PowerofFour {
    /**
     *
     * @param num
     * @return
     */
    public boolean isPowerOfFour(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0xaaaaaaaa) == 0);
    }
}
