import java.util.*;

public class _140_WordBreakII {
    class Solution {

        public List<String> wordBreak(String s, List<String> wordDict) {
            return helper(s, new HashSet<>(wordDict), new HashMap<String,List<String>>());
        }

        private List<String> helper(String s, Set<String> wordDict, Map<String,List<String>> map) {
            List<String> res = new ArrayList<String>();
            if(s == null || s.length() == 0) {
                return res;
            }
            if(map.containsKey(s)) {
                return map.get(s);
            }
            if(wordDict.contains(s)) {
                res.add(s);
            }
            for(int i = 1 ; i < s.length() ; i++) {
                String t = s.substring(0, i);
                if(wordDict.contains(t)) {
                    List<String> list = helper(s.substring(i) , wordDict, map);
                    for(int j = 0 ; j < list.size() ; j++) {
                        res.add(t + " " + list.get(j));
                    }
                }
            }
            map.put(s , res);
            return res;
        }
    }
}
