import java.util.*;

public class _140_WordBreakII {
    class Solution {
        public List<String> wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet<>();
            int maxLen = 0;
            for(String word : wordDict) {
                maxLen = Math.max(maxLen, word.length());
                set.add(word);
            }
            Map<Integer, List<String>> memo = new HashMap<>();
            return helper(s, set, memo, 0, maxLen);
        }

        private List<String> helper(String s, Set<String> set, Map<Integer, List<String>> memo, int start, int maxLen) {
            if(memo.containsKey(start)) {
                return memo.get(start);
            }
            List<String> list = new ArrayList<>();
            if(start == s.length()) {
                list.add("");
            }
            for(int i = start; i < start + maxLen && i < s.length(); i++) {
                String subStr = s.substring(start, i + 1);
                if(set.contains(subStr)) {
                    List<String> nextList = helper(s, set, memo, i + 1, maxLen);
                    for(String nextStr : nextList) {
                        if(nextStr.equals("")) {
                            list.add(subStr);
                        } else {
                            list.add(subStr + " " + nextStr);
                        }
                    }
                }
            }
            memo.put(start, list);
            return list;
        }
    }
}
