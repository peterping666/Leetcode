public class _696_CountBinarySubstrings {
    class Solution {
        public int countBinarySubstrings(String s) {
            int res = 0;
            int cur = 1;
            int pre = 0;
            for(int i = 1; i < s.length(); i++) {
                if(s.charAt(i) == s.charAt(i-1)) {
                    cur++;
                } else {
                    res += Math.min(cur, pre);
                    pre = cur;
                    cur = 1;
                }
            }
            return res + Math.min(pre, cur);
        }
    }
}
