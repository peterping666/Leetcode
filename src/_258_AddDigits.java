public class _258_AddDigits {
    /**
     * Time O(logn)
     * Space O(logn)
     * @param num
     * @return
     */
    public int addDigits1(int num) {
        if(num < 10) return num;
        int sum = 0;
        while(num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return addDigits1(sum);
    }

    /**
     * Time O(logn)
     * Space O(1)
     * @param num
     * @return
     */
    public int addDigits2(int num) {
        int digitalRoot = 0;
        while (num > 0) {
            digitalRoot += num % 10;
            num = num / 10;

            if (num == 0 && digitalRoot > 9) {
                num = digitalRoot;
                digitalRoot = 0;
            }
        }
        return digitalRoot;
    }
}
