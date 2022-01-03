import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1044_LongestDuplicateSubstring {
    /**
     * Time O(nlogn)
     * Space O(n)
     */
    class Solution {
        public String longestDupSubstring(String s) {
            int n = s.length(), left = 0, right = n-1;
            while(left < right) {
                int mid = right - (right - left) / 2;
                if(longest(s, mid) != null) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            String res = longest(s, left);
            return res == null ? "" : res;
        }

        private String longest(String s, int len) {
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
                                return str;
                            }
                        }
                    }
                    map.put(hash, new ArrayList<>());
                    map.get(hash).add(j);
                }
            }
            return null;
        }
    }
}
