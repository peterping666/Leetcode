import java.util.ArrayList;
import java.util.List;

public class _22_GenerateParentheses {
    /**
     * Time O()
     * Space O()
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(list, 0, 0, n, "");
        return list;
    }

    private void helper(List<String> list, int open, int close, int n, String path) {
        if(path.length() == n * 2) {
            list.add(path);
            return;
        }
        if(open < n) {
            helper(list, open+1, close, n, path+"(");
        }
        if(close < open) {
            helper(list, open, close+1, n, path+")");
        }
    }
}
