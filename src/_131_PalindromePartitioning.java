import java.util.ArrayList;
import java.util.List;

public class _131_PalindromePartitioning {
    /**
     * Time O(2^n)
     * Space O(n)
     */
    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();
            helper(res, s, new ArrayList<>(), 0);
            return res;
        }

        private void helper(List<List<String>> res, String s, List<String> list, int index) {
            if(index == s.length()) {
                res.add(new ArrayList<>(list));
                return;
            }
            for(int i = index; i < s.length(); i++) {
                if(valid(s, index, i)) {
                    String str = s.substring(index, i + 1);
                    list.add(str);
                    helper(res, s, list, i+1);
                    list.remove(list.size() - 1);
                }
            }
        }

        private boolean valid(String s, int left, int right) {
            while(left < right) {
                if(s.charAt(left++) != s.charAt(right--)) {
                    return false;
                }
            }
            return true;
        }
    }
}
