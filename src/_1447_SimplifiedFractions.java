import java.util.ArrayList;
import java.util.List;

public class _1447_SimplifiedFractions {
    class Solution {
        public List<String> simplifiedFractions(int n) {
            List<String> ans = new ArrayList<>();
            for (int denominator = 2; denominator <= n; ++denominator) {
                for (int numerator = 1; numerator < denominator; ++numerator) {
                    // check if the fraction is simplified
                    if (gcd(numerator, denominator) == 1) {
                        ans.add(numerator + "/" + denominator);
                    }
                }
            }
            return ans;
        }

        // greatest common divisor
        private int gcd(int x, int y) {
            while(y != 0) {
                int tmp = y;
                y = x % y;
                x = tmp;
            }
            return x;
        }

        // least common multiple
        private int lcm(int x, int y) {
            return x * y / gcd(x, y);
        }
    }
}
