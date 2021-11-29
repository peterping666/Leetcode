public class _204_CountPrimes {
    /**
     * Time： O(nloglogn)
     * Space: O(n)
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
