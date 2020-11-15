public class _738_MonotoneIncreasingDigits {
    class Solution {
        public int monotoneIncreasingDigits(int N) {
            char[] chars = Integer.toString(N).toCharArray();
            int marker = chars.length;
            for (int i = chars.length - 1; i > 0; i--)
                if (chars[i] < chars[i - 1]) {
                    chars[i - 1] -= 1;
                    marker = i;
                }
            for (int i = marker; i < chars.length; i++) {
                chars[i] = '9';
            }
            return Integer.parseInt(new String(chars));
        }
    }
}
