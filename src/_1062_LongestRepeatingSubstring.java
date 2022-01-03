import java.util.*;

public class _1062_LongestRepeatingSubstring {

    /**
     * Time O(nlogn)
     * Space O(n)
     */
    class Solution1 {
        public int longestRepeatingSubstring(String s) {
            int n = s.length(), left = 0, right = n-1;
            while(left < right) {
                int mid = right - (right - left) / 2;
                if(valid(s, mid)) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            if(valid(s, left)) {
                return left;
            }
            return 0;
        }

        private boolean valid(String s, int len) {
            Set<Long> set = new HashSet<>();
            long hash = 0, mod = (long)(1e9+7), pow = 1, base = 26;
            for(int i = 0; i < len; i++) {
                pow = pow * base % mod;
            }
            for(int i = 0, j = 0; i < s.length(); i++) {
                hash = (hash * base + s.charAt(i) - 'a') % mod;
                if(i - j + 1 > len) {
                    hash = (hash - (s.charAt(j++) - 'a') * pow % mod + mod) % mod;
                }
                if(i - j + 1 >= len) {
                    if(!set.add(hash)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /**
     * Time O(nlogn)
     * Space O(n)
     */
    class Solution2 {
        public int longestRepeatingSubstring(String s) {
            int n = s.length(), left = 0, right = n-1;
            while(left < right) {
                int mid = right - (right - left) / 2;
                if(valid(s, mid)) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            if(valid(s, left)) {
                return left;
            }
            return 0;
        }

        private boolean valid(String s, int len) {
            Map<Long, List<Integer>> map = new HashMap<>();
            long hash = 0, mod = (long)(1e9+7), pow = 1, base = 26;
            for(int i = 0; i < len; i++) {
                pow = pow * base % mod;
            }
            for(int i = 0, j = 0; i < s.length(); i++) {
                hash = (hash * base + s.charAt(i) - 'a') % mod;
                if(i - j + 1 > len) {
                    hash = (hash - (s.charAt(j++) - 'a') * pow % mod + mod) % mod;
                }
                if(i - j + 1 >= len) {
                    if(map.containsKey(hash)) {
                        for(int start : map.get(hash)) {
                            String str = s.substring(j, i+1);
                            if(str.equals(s.substring(start, start + len))) {
                                return true;
                            }
                        }
                    }
                    map.put(hash, new ArrayList<>());
                    map.get(hash).add(j);
                }
            }
            return false;
        }
    }
}
