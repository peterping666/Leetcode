import java.util.ArrayList;
import java.util.List;

public class _131_PalindromePartitioning {
    /**
     * Time O(2^n)
     * Space O(n)
     * @return
     */
    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();
            helper(s, res, new ArrayList<>(), 0);
            return res;
        }

        private void helper(String s, List<List<String>> res, List<String> group, int index) {
            if(index == s.length()) {
                res.add(new ArrayList<>(group));
                return;
            }
            for(int i = index; i < s.length(); i++) {
                if(isPalindrome(s, index, i)) {
                    group.add(s.substring(index, i + 1));
                    helper(s, res, group, i + 1);
                    group.remove(group.size() - 1);
                }
            }
        }

        private boolean isPalindrome(String s, int left, int right) {
            while(left < right) {
                if(s.charAt(left++) != s.charAt(right--)) {
                    return false;
                }
            }
            return true;
        }
    }
}
