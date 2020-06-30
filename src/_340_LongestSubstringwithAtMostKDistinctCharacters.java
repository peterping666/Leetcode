import java.util.Collections;
import java.util.HashMap;

public class _340_LongestSubstringwithAtMostKDistinctCharacters {
    /**
     * Time O(n)
     * Space O(k)
     * @param s
     * @param k
     * @return
     */
    public int lengthOfLongestSubstringKDistinct1(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while(map.size() > k) {
                char d = s.charAt(j++);
                if(map.get(d) > 1) {
                    map.put(d, map.get(d) - 1);
                } else {
                    map.remove(d);
                }
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    /**
     * Time O((n-k)*k)
     * Space O(k)
     * @param s
     * @param k
     * @return
     */
    public int lengthOfLongestSubstringKDistinct2(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, i);
            if(map.size() > k) {
                j = Collections.min(map.values());
                map.remove(s.charAt(j++));
            }
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
