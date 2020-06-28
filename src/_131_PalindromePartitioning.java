import java.util.ArrayList;
import java.util.List;

public class _131_PalindromePartitioning {
    /**
     * Time O(2^n)
     * Space O(n)
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        List<List<String>> lists = new ArrayList<>();
        helper(lists, new ArrayList<>(), s, 0);
        return lists;
    }

    private void helper(List<List<String>> lists, List<String> path, String s, int start) {
        if(start == s.length()) {
            lists.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i < s.length(); i++) {
            String str = s.substring(start, i + 1);
            if(isPalindrome(str)) {
                path.add(str);
                helper(lists, path, s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str) {
        int l = 0, r = str.length() - 1;
        while(l < r) {
            if(str.charAt(l++) != str.charAt(r--)) return false;
        }
        return true;
    }
}
