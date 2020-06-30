import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _30_SubstringwithConcatenationofAllWords {
    /**
     * Time O(l * m * n) l is the length of s, m is length of words, n is length of a single word
     * Space O(m * n)
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if(s.length() == 0 || words.length == 0) return list;
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int n = words.length;
        int m = words[0].length();
        for(int i = 0; i <= s.length() - n*m; i++) {
            HashMap<String, Integer> copy = new HashMap<>(map);
            int k = n, j = i;
            while(k > 0) {
                String str = s.substring(j, j+m);
                if(!copy.containsKey(str) || copy.get(str) == 0) {
                    break;
                }
                copy.put(str, copy.get(str) - 1);
                k--;
                j += m;
            }
            if(k == 0) {
                list.add(i);
            }
        }
        return list;
    }
}
