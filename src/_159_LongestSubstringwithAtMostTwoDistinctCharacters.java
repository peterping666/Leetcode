import java.util.Collections;
import java.util.HashMap;

public class _159_LongestSubstringwithAtMostTwoDistinctCharacters {
    /**
     * Time O(n)
     * Space O(1)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringTwoDistinct1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0, j = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            while(map.size() > 2) {
                char start = s.charAt(j);
                if(map.get(start) > 1) {
                    map.put(start, map.get(start) - 1);
                } else {
                    map.remove(start);
                }
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    /**
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringTwoDistinct2(String s) {
        int n = s.length();
        if (n < 3) return n;

        // sliding window left and right pointers
        int left = 0;
        int right = 0;
        // hashmap character -> its rightmost position
        // in the sliding window
        HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();

        int max_len = 2;

        while (right < n) {
            // slidewindow contains less than 3 characters
            if (hashmap.size() < 3)
                hashmap.put(s.charAt(right), right++);

            // slidewindow contains 3 characters
            if (hashmap.size() == 3) {
                // delete the leftmost character
                int del_idx = Collections.min(hashmap.values());
                hashmap.remove(s.charAt(del_idx));
                // move left pointer of the slidewindow
                left = del_idx + 1;
            }

            max_len = Math.max(max_len, right - left);
        }
        return max_len;
    }

    /**
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringTwoDistinct3(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        for(int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, i);
            if(map.size() == 3) {
                j = Collections.min(map.values());
                map.remove(s.charAt(j++));
            }
            maxLen = Math.max(maxLen, i - j + 1);
        }
        return maxLen;
    }
}
