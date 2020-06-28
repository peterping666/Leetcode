public class _214_ShortestPalindrome {
    /**
     * Time O(n^2)
     * Space O(n)
     * @param s
     * @return
     */
    public String shortestPalindrome(String s) {
        for(int i = s.length(); i >= 0; i--) {
            if(isPalindrome(s, i)) {
                return new StringBuilder(s.substring(i)).reverse() + s;
            }
        }
        return s;
    }

    private boolean isPalindrome(String str, int i) {
        int l = 0, r = i-1;
        while(l < r) {
            if(str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
