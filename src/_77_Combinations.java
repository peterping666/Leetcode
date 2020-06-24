import java.util.ArrayList;
import java.util.List;

public class _77_Combinations {
    /**
     * Time O(k * C(k, N))
     * Space O(k * C(k, N))
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        helper(lists, n, k, 1, new ArrayList<>());
        return lists;
    }

    private void helper(List<List<Integer>> lists, int n, int k,
                        int start, List<Integer> path) {
        if(k == 0) {
            lists.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i <= n; i++) {
            path.add(i);
            helper(lists, n, k - 1, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
