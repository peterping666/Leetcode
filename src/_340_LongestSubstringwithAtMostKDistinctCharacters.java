import java.util.HashMap;

public class _340_LongestSubstringwithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct1(String s, int k) {
        /**
         * Time O(n)
         * Space O(k)
         */
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while(map.size() > k) {
                char d = s.charAt(j);
                if(map.get(d) > 1) {
                    map.put(d, map.get(d) - 1);
                } else {
                    map.remove(d);
                }
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }


}
