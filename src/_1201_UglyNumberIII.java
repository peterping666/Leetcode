public class _1201_UglyNumberIII {
    class Solution {
        public int nthUglyNumber(int n, int a, int b, int c) {
            int left = 1, right = Integer.MAX_VALUE;
            while(left < right) {
                int mid = left + (right - left) / 2;
                if(count(mid, a, b, c) < n) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }

        private long count(long num, long a, long b, long c) {
            return num/a + num/b + num/c - num/lcm(a,b) - num/lcm(b,c) - num/lcm(a,c) + num/lcm(lcm(a,b), c);
        }

        private long lcm(long a, long b) {
            return a*b / gcd(a,b);
        }

        private long gcd(long a, long b) {
            if(a == 0) {
                return b;
            }
            return gcd(b%a, a);
        }
    }
}
