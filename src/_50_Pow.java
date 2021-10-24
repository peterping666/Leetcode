public class _50_Pow {

    class Solution {
        public double myPow(double x, int n) {
            if(n < 0) {
                if(x == 0) {
                    throw new IllegalArgumentException("x and n can't both be zero");
                }
                return 1 / pow(x, -n);
            }
            return pow(x, n);

        }

        private double pow(double x, int n) {
            if(n == 0) {
                return 1;
            }

            double half = pow(x, n / 2);

            if(n % 2 == 0) {
                return half * half;
            } else {
                return half * half * x;
            }
        }
    }

    /**
     * Time O(logn)
     * Space O(logn)
     * @param x
     * @param n
     * @return
     */
    public double myPow1(double x, int n) {
        if(n < 0) {
            x = 1 / x;
            n = -n;
        }
        return fastPow(x, n);
    }
    private double fastPow(double x, int n) {
        if(n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if(n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    /**
     * Time O(logn)
     * Space O(1)
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double current_product = x;
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans = ans * current_product;
            }
            current_product = current_product * current_product;
        }
        return ans;
    }
}
