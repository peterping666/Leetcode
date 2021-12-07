import java.util.HashMap;

public class _340_LongestSubstringwithAtMostKDistinctCharacters {
    /**
     * Time O(n)
     * Space O(k)
     */
    class Solution {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            HashMap<Character, Integer> map = new HashMap<>();
            int res = 0;
            for(int i = 0, j = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
                while(map.size() > k) {
                    char ch = s.charAt(j++);
                    map.put(ch, map.get(ch) - 1);
                    if(map.get(ch) == 0) {
                        map.remove(ch);
                    }
                }
                res = Math.max(res, i - j + 1);
            }
            return res;
        }
    }
}
