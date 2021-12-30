public class _214_ShortestPalindrome {

    class Solution1 {
        public String shortestPalindrome(String s) {
            String str = new StringBuilder(s).reverse().toString();
            for (int i = 0; i <= str.length(); i++) {
                if (s.startsWith(str.substring(i))) {
                    return str.substring(0, i) + s;
                }
            }
            return str + s;
        }
    }

    /**
     * Time O(n^2)
     */
    class Solution2 {
        public String shortestPalindrome(String s) {
            for(int i = s.length() - 1; i >= 0; i--) {
                if(valid(s, i)) {
                    return new StringBuilder(s.substring(i+1)).reverse() + s;
                }
            }
            return s;
        }

        private boolean valid(String s, int i) {
            int left = 0, right = i;
            while(left < right) {
                if(s.charAt(left++) != s.charAt(right--)) {
                    return false;
                }
            }
            return true;
        }
    }
}
