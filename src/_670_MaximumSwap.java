public class _670_MaximumSwap {
    class Solution {
        public int maximumSwap(int num) {
            char[] digits = String.valueOf(num).toCharArray();
            int[] lastIndex = new int[10];
            for(int i = 0; i < digits.length; i++) {
                lastIndex[digits[i] - '0'] = i;
            }
            int max = 9;
            for(int i = 0; i < digits.length; i++) {
                for(int j = max; j > digits[i] - '0'; j--) {
                    if(lastIndex[j] > i) {
                        char tmp = digits[i];
                        digits[i] = digits[lastIndex[j]];
                        digits[lastIndex[j]] = tmp;
                        return Integer.valueOf(new String(digits));
                    }
                }
                max = digits[i] - '0';
            }
            return num;
        }
    }
}
