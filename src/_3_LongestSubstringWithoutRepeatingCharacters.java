import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class _3_LongestSubstringWithoutRepeatingCharacters {
    class Solution1 {
        public int lengthOfLongestSubstring(String s) {
            int[] count = new int[256];
            int maxLen = 0;
            for(int i = 0, j = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                count[c]++;
                while(count[c] > 1) {
                    count[s.charAt(j++)]--;
                }
                maxLen = Math.max(maxLen, i - j + 1);
            }
            return maxLen;
        }
    }

    /**
     * Time O(n)
     * Space O(n)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                j = Math.max(j, map.get(c) + 1);
            }
            map.put(c, i);
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    /**
     * Time O(2n)
     * Space O(n)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
