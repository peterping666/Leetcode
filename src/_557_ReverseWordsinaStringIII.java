public class _557_ReverseWordsinaStringIII {
    /**
     * Time O(n)
     * Space O(n)
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        for(int i = 0, j = 0; i < chars.length; i++) {
            if(chars[i] == ' ') {
                reverse(chars, j, i - 1);
                j = i + 1;
            } else if(i == chars.length - 1){
                reverse(chars, j, i);
            }
        }
        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while(start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }
}
