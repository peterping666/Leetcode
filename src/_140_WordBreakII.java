import java.util.*;

public class _140_WordBreakII {
    class Solution1 {
        public List<String> wordBreak(String s, List<String> wordDict) {
            List<String> res = new ArrayList<>();
            Set<String> set = new HashSet<>(wordDict);
            helper(set, s, "", 0, res);
            return res;
        }

        private void helper(Set<String> set, String s, String curStr, int index, List<String> res) {
            if(index == s.length()) {
                res.add(curStr.trim());
                return;
            }
            for(int i = index; i < s.length(); i++) {
                String str = s.substring(index, i + 1);
                if(set.contains(str)) {
                    helper(set, s, curStr + str + " ", i + 1, res);
                }

            }
        }
    }

    class Solution2 {
        int maxLen = 0;
        public List<String> wordBreak(String s, List<String> wordDict) {
            Set<String> hs = new HashSet<>();
            for(String w: wordDict)
            {
                hs.add(w);
                if(w.length()>maxLen) maxLen = w.length(); //get the maxLen of words
            }
            Map<Integer, List<String>> map = new HashMap<>();
            return helper(hs, s, 0, map);
        }

        public List<String> helper(Set<String> hs, String s, int start, Map<Integer, List<String>> map)
        {
            if(map.containsKey(start)) return map.get(start);
            List<String> list = new ArrayList<>();
            if(start==s.length())  list.add("");
            //reduce the # of iterations using maxLen
            for(int i=start; i<start+maxLen&&i<s.length(); i++)
            {
                if(hs.contains(s.substring(start, i+1)))
                {
                    List<String> nexts = helper(hs, s, i+1, map);
                    for(String next:nexts)
                    {
                        if(next=="")//reaches the end
                            list.add(s.substring(start, i+1)+next);
                        else
                            list.add(s.substring(start, i+1) + " " + next);
                    }
                }
            }
            map.put(start, list);
            return list;
        }
    }

    class Solution3 {
        int maxLen = 0, minLen = 0;
        public List<String> wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet<>(wordDict);
            for(String w : wordDict){
                maxLen = Math.max(maxLen, w.length());
                minLen = Math.min(minLen, w.length());
            }
            Map<Integer, List<String>> map = new HashMap<>();
            return dfs(s, set, map, 0);
        }

        List<String> dfs(String s, Set<String> set, Map<Integer, List<String>> map, int start){
            if(map.containsKey(start)) return map.get(start);
            List<String> list = new ArrayList<>();
            if(s.length() == start ) list.add("");
            for(int end = start + minLen; end<=s.length() && end<=start+maxLen ; end++){
                String sub = s.substring(start, end);
                if(set.contains(sub)){
                    List<String> nexts = dfs(s, set, map, end);
                    for(String next : nexts)
                        if(next == "") list.add(s.substring(start,end) + next);
                        else list.add(s.substring(start,end) + " " + next);
                }
                map.put(start, list);
            }
            return list;
        }
    }
}
