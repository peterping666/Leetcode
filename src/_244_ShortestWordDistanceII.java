import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _244_ShortestWordDistanceII {
    /**
     * Time O(m + n)
     * Space O(n)
     */
    class WordDistance {
        HashMap<String, List<Integer>> map;
        public WordDistance(String[] words) {
            map = new HashMap<>();
            for(int i = 0; i < words.length; i++) {
                map.putIfAbsent(words[i], new ArrayList<>());
                map.get(words[i]).add(i);
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> l1 = map.get(word1);
            List<Integer> l2 = map.get(word2);
            int i = 0, j = 0, min = Integer.MAX_VALUE;
            while(i < l1.size() && j < l2.size()) {
                int idx1 = l1.get(i);
                int idx2 = l2.get(j);
                min = Math.min(Math.abs(idx1 - idx2), min);
                if(idx1 > idx2) {
                    j++;
                } else {
                    i++;
                }
            }
            return min;
        }
    }

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
}
