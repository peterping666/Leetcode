public class _5_LongestPalindromicSubstring {
    /**
     * Time O(n^2)
     * Space O(1)
     */
    String res = "";
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }
        return res;
    }

    private void helper(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if(right - left - 1 > res.length()) {
            res = s.substring(left + 1, right);
        }
    }
}
