public class _670_MaximumSwap {
    class Solution {
        public int maximumSwap(int num) {
            char[] digits = Integer.toString(num).toCharArray();
            int[] lastIndex = new int[10];
            // get the last index of each digit
            for(int i = 0; i < digits.length; i++) {
                lastIndex[digits[i] - '0'] = i;
            }
            for(int i = 0; i < digits.length; i++) {
                // from 9 to current digit, find a digit that is on the right side of current digit,
                // then swap them
                for(int j = 9; j > digits[i] - '0'; j--) {
                    if(lastIndex[j] > i) {
                        char tmp = digits[i];
                        digits[i] = digits[lastIndex[j]];
                        digits[lastIndex[j]] = tmp;
                        return Integer.valueOf(new String(digits));
                    }
                }
            }
            return num;
        }
    }
}
