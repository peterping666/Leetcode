package Laicode;

public class _12_FibonacciNumber {
    public class Solution {
        public long fibonacci(int K) {
            if(K <= 0) {
                return 0;
            }
            long dp0 = 0;
            long dp1 = 1;
            for(int i = 2; i <= K; i++) {
                long tmp = dp1;
                dp1 = dp0 + dp1;
                dp0 = tmp;
            }
            return dp1;
        }
    }

}
