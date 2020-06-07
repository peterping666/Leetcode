public class _186_ReverseWordsinaStringII {
    /**
     * Time O(n)
     * Space O(1)
     * @param s
     */
    public void reverseWords(char[] s) {
        for(int i = 0, j = 0; i < s.length; i++) {
            if(s[i] == ' ') {
                if(i == 0) continue;
                reverse(s, j, i - 1);
                j = i + 1;
                i++;
            }
            if(i == s.length - 1) {
                reverse(s, j, i);
            }
        }
        reverse(s, 0, s.length - 1);
    }

    private void reverse(char[] s, int start, int end) {
        while(start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }
}
