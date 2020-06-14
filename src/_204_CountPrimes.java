public class _204_CountPrimes {
    /**
     * Time： 求一组质数：O(nloglogn)
     * Space： 1 - n-1 判断质数(n * n^1/2)
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        boolean[] notPrimes = new boolean[n];
        int count = 0;
        for(int i = 2; i < n; i++) {
            if(!notPrimes[i]) {
                count++;
                for(int j = 2; j * i < n; j++) {
                    notPrimes[j * i] = true;
                }
            }
        }
        return count;
    }
}
