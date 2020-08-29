import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1048_LongestStringChain {
    /**
     * Time O(NlogN + NL^2) L represents the length of string
     * Space O(NL)
     */
    class Solution {
        public int longestStrChain(String[] words) {
            Map<String, Integer> dp = new HashMap<>();
            Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
            int res = 0;
            for (String word : words) {
                int best = 0;
                for (int i = 0; i < word.length(); ++i) {
                    String prev = word.substring(0, i) + word.substring(i + 1);
                    best = Math.max(best, dp.getOrDefault(prev, 0) + 1);
                }
                dp.put(word, best);
                res = Math.max(res, best);
            }
            return res;
        }
    }
}
