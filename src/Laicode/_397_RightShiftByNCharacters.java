package Laicode;

public class _397_RightShiftByNCharacters {
    public class Solution {
        public String rightShift(String input, int n) {
            char[] chars = input.toCharArray();
            int len = chars.length;
            if(len == 0) {
                return input;
            }
            n %= len;
            reverse(chars, 0, len);
            reverse(chars, 0, n);
            reverse(chars, n, len);
            return new String(chars);
        }

        private void reverse(char[] chars, int l, int r) {
            int left = l;
            int right = r - 1;
            while(left < right) {
                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
                left++;
                right--;
            }
        }
    }

}
