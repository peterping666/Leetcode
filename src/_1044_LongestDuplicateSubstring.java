import java.util.HashSet;

public class _1044_LongestDuplicateSubstring {
    class Solution {
        public String longestDupSubstring(String S) {
            int left = 1;
            int right = S.length() - 1;
            int start = 0;
            int maxLen = 0;
            while(left <= right) {
                int mid = (left + right + 1) / 2;
                int cur = -1;
                cur = searchDuplicate(S, mid);
                if(cur != -1) {
                    left = mid + 1;
                    maxLen = mid;
                    start = cur;
                } else {
                    right = mid - 1;
                }
            }
            return S.substring(start, start + maxLen);
        }

        private int searchDuplicate(String s, int len) {
            long val = 0;
            long modulus = (long)Math.pow(2, 32);
            long pow = 1;
            for(int i = 0; i < len; i++) {
                pow = pow * 26 % modulus;
            }
            HashSet<Long> set = new HashSet<>();
            for(int i = 0, j = 0; i < s.length(); i++) {
                val = (val * 26 + s.charAt(i) - 'a') % modulus;
                if(i - j + 1 > len) {
                    val -= ((s.charAt(j++) - 'a') * pow) % modulus;
                }
                if(i - j + 1 == len && !set.add(val)) {
                    return j;
                }
            }
            return -1;
        }
    }
}
