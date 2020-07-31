public class _670_MaximumSwap {
    class Solution {
        public int maximumSwap(int num) {
            char[] digits = Integer.toString(num).toCharArray();
            int[] buckets = new int[10];
            for(int i = 0; i < digits.length; i++) {
                buckets[digits[i] - '0'] = i;
            }
            for(int i = 0; i < digits.length; i++) {
                for(int j = 9; j > digits[i] - '0'; j--) {
                    if(buckets[j] > i) {
                        char tmp = digits[i];
                        digits[i] = digits[buckets[j]];
                        digits[buckets[j]] = tmp;
                        return Integer.valueOf(new String(digits));
                    }
                }
            }
            return num;
        }
    }
}
