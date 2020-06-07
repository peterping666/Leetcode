public class _50_Pow {

    // Time: O(logn)
    // Space : O(n)

    // Recursion
    public double myPow1(double x, int n) {
        if(n > 0) {
            return helper(x, n);
        }
        return 1.0 / helper(x, n);
    }

    private double helper(double x, int n) {
        if(n == 0) {
            return 1;
        }
        double val = helper(x, n / 2);
        if(n % 2 == 0) {
            return val * val;
        }
        return val * val * x;
    }


    // Time: O(logn)
    // Space : O(1)

    // Iteration
    public double myPow2(double x, int n) {
        long exp = Math.abs((long) n); // in case when n = Integer.MIN_VALUE
        double res = 1;
        while(exp > 0) {
            if(exp % 2 != 0) {
                res *= x;
            }
            x *= x;
            exp /= 2;
        }
        if(n < 0) {
            return 1.0 / res;
        }
        return res;
    }
}
