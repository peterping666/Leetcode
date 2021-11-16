import java.util.HashMap;
import java.util.Map;

public class _395_LongestSubstringwithAtLeastKRepeatingCharacters {
    class Solution1 {
        public int longestSubstring(String s, int k) {
            int res = 0;
            for(int i = 1; i <= 26; i++) {
                res = Math.max(res, helper(s, i, k));
            }
            return res;
        }

        private int helper(String s, int unique, int k) {
            int counter = 0;
            int[] freq = new int[26];
            int count = 0;
            int res = 0;
            for(int i = 0, j = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if(freq[index] == 0) {
                    count++;
                }
                if(++freq[index] == k) {
                    counter++;
                }
                while(count > unique) {
                    int idx = s.charAt(j++) - 'a';
                    if(freq[idx] == k) {
                        counter--;
                    }
                    if(--freq[idx] == 0) {
                        count--;
                    }
                }
                if(counter == unique) {
                    res = Math.max(res, i - j + 1);
                }
            }
            return res;
        }
    }

    class Solution2 {
        public int longestSubstring(String s, int k) {
            int res = 0;
            for(int i = 1; i <= 26; i++) {
                res = Math.max(res, helper(s, i, k));
            }
            return res;
        }

        private int helper(String s, int unique, int k) {
            int counter = 0;
            Map<Character, Integer> map = new HashMap<>();
            int res = 0;
            for(int i = 0, j = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
                if(map.get(c) == k) {
                    counter++;
                }
                while(map.size() > unique) {
                    char ch = s.charAt(j++);
                    if(map.get(ch) == k) {
                        counter--;
                    }
                    map.put(ch, map.get(ch) - 1);
                    if(map.get(ch) == 0) {
                        map.remove(ch);
                    }
                }
                if(counter == unique) {
                    res = Math.max(res, i - j + 1);
                }
            }
            return res;
        }
    }
}
