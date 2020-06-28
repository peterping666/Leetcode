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

    /**
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        int[] indices = new int[2];
        for(int i = 0; i < s.length(); i++) {
            helper2(s, i, i, indices);
            helper2(s, i, i + 1, indices);
        }
        return s.substring(indices[0], indices[1]);
    }

    private void helper2(String s, int l, int r, int[] indices) {
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        if(r - l - 1 > indices[1] - indices[0]) {
            indices[0] = l + 1;
            indices[1] = r;
        }
    }
}
