public class _1405_LongestHappyString {
    class Solution {

        public String longestDiverseString(int a, int b, int c) {
            return generate(a, b, c, "a", "b", "c");
        }

        String generate(int a, int b, int c, String aa, String bb, String cc) {
            if (a < b)
                return generate(b, a, c, bb, aa, cc);
            if (b < c)
                return generate(a, c, b, aa, cc, bb);
            if (b == 0)
                return repeat(aa, Math.min(2, a));
            int use_a = Math.min(2, a), use_b = a - use_a >= b ? 1 : 0;
            return repeat(aa, use_a) + repeat(bb, use_b) +
                    generate(a - use_a, b - use_b, c, aa, bb, cc);
        }

        private String repeat(String s, int n) {
            while(--n > 0) {
                s += s;
            }
            return s;
        }
    }
}
