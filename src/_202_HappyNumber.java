import java.util.HashSet;
import java.util.Set;

public class _202_HappyNumber {
    /**
     * Floyd Cycle
     */
    class Solution1 {
        public boolean isHappy(int n) {
            int slow, fast;
            slow = fast = n;
            do {
                slow = digitSquareSum(slow);
                fast = digitSquareSum(fast);
                fast = digitSquareSum(fast);
                if(fast == 1) {
                    return true;
                }
            } while(slow != fast);
            return false;
        }

        int digitSquareSum(int n) {
            int sum = 0, tmp;
            while (n != 0) {
                tmp = n % 10;
                sum += tmp * tmp;
                n /= 10;
            }
            return sum;
        }
    }

    class Solution2 {
        public boolean isHappy(int n) {
            Set<Integer> inLoop = new HashSet<Integer>();
            int squareSum,remain;
            while (inLoop.add(n)) {
                squareSum = 0;
                while (n > 0) {
                    remain = n%10;
                    squareSum += remain*remain;
                    n /= 10;
                }
                if (squareSum == 1)
                    return true;
                else
                    n = squareSum;

            }
            return false;
        }
    }
}
