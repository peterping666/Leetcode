public class _1137_NthTribonacciNumber {
    /**
     * Time O(n)
     * Space O(1)
     * @param n
     * @return
     */
    public int tribonacci1(int n) {
        int[] nums = new int[3];
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 1;
        if(n < 3) return nums[n];
        while(n - 3 >= 0) {
            int temp = nums[2];
            nums[2] = nums[0] + nums[1] + nums[2];
            nums[0] = nums[1];
            nums[1] = temp;
            n--;
        }
        return nums[2];
    }
    public int tribonacci2(int n) {
        if (n < 3) return n == 0 ? 0 : 1;
        int tmp, x = 0, y = 1, z = 1;
        for (int i = 3; i <= n; ++i) {
            tmp = x + y + z;
            x = y;
            y = z;
            z = tmp;
        }
        return z;
    }
}
