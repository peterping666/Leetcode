import java.util.ArrayList;
import java.util.List;

public class _438_FindAllAnagramsinaString {
    /**
     * Time O(m+n)
     * Space O(1)
     */
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int n = p.length();
            int[] freq = new int[26];
            for(int i = 0; i < n; i++) {
                freq[p.charAt(i) - 'a']++;
            }
            int counter = n;
            List<Integer> res = new ArrayList<>();
            for(int i = 0, j = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if(--freq[index] >= 0) {
                    counter--;
                }
                if(i - j + 1 > n && ++freq[s.charAt(j++) - 'a'] > 0) {
                    counter++;
                }
                if(counter == 0) {
                    res.add(j);
                }
            }
            return res;
        }
    }
}
