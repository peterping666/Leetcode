public class _5_LongestPalindromicSubstring {
    /**
     * Time O(n^2)
     * Space O(1)
     */
    class Solution1 {
        public String longestPalindrome(String s) {
            int[] indices = new int[2];
            for(int i = 0; i < s.length(); i++) {
                helper(s, i, i, indices);
                helper(s, i, i + 1, indices);
            }
            return s.substring(indices[0], indices[1]);
        }

        private void helper(String s, int left, int right, int[] indices) {
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            int len = right - left - 1;
            if(len > indices[1] - indices[0]) {
                indices[0] = left + 1;
                indices[1] = right;
            }
        }
    }

    class Solution2 {
        public String longestPalindrome(String s) {
            int start = 0;
            int maxLen = 0;
            for(int i = 0; i < s.length(); i++) {
                int odd = palindrome(s, i, i);
                if(odd > maxLen) {
                    maxLen = odd;
                    start = i - odd / 2;
                }
                int even = palindrome(s, i, i + 1);
                if(even > maxLen) {
                    maxLen = even;
                    start = i - even / 2 + 1;
                }
            }
            return s.substring(start, start + maxLen);
        }

        private int palindrome(String s, int left, int right) {
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return right - left - 1;
        }
    }
}
