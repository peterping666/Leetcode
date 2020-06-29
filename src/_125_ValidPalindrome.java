public class _125_ValidPalindrome {
    /**
     * Time O(n)
     * Space O(1)
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r) {
            while(l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while(l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if(l < r && Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
