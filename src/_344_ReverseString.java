public class _344_ReverseString {
    /**
     * Time O(n)
     * Space O(1)
     * @param s
     */
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while(start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            end--;
            start++;
        }
    }
}
