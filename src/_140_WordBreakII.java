import java.util.*;

public class _140_WordBreakII {
    class Solution1 {
        public List<String> wordBreak(String s, List<String> wordDict) {
            List<String> res = new ArrayList<>();
            helper(new HashSet<>(wordDict), s, "", 0, res);
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
}
