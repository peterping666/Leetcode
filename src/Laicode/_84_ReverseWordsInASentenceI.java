package Laicode;

public class _84_ReverseWordsInASentenceI {
    public class Solution {
        public String reverseWords(String input) {
            char[] chars = input.toCharArray();
            int n = chars.length;
            for(int i = 0, j = 0; i < n; i++) {
                while(i < n && chars[i] != ' ') {
                    i++;
                }
                reverse(chars, j, i);
                j = i + 1;
            }
            reverse(chars, 0, n);
            return new String(chars);
        }

        private void reverse(char[] chars, int l, int r) {
            int left = l;
            int right = r - 1;
            while(left < right) {
                char tmp = chars[left];
                chars[left++] = chars[right];
                chars[right--] = tmp;
            }
        }
    }

}
