public class _459_RepeatedSubstringPattern {
    /**
     * Time O(n)
     * Space O(n)
     */
    class Solution {
        public boolean repeatedSubstringPattern(String s) {
            String ss = s.substring(1) + s.substring(0, s.length() - 1);
            return ss.indexOf(s) != -1;
        }
    }
}
