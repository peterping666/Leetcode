import java.util.ArrayList;
import java.util.List;

public class _216_CombinationSumIII {
    /**
     *
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new ArrayList<>();
        helper(lists, new ArrayList<>(), 1, k, n);
        return lists;
    }

    private void helper(List<List<Integer>> lists, List<Integer> path, int start,
                        int k, int n) {
        if(k < 0 || n < 0) return;
        if(n == 0 && k == 0) {
            lists.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i <= 9; i++) {
            path.add(i);
            helper(lists, path, i + 1, k - 1, n - i);
            path.remove(path.size() - 1);
        }
    }
}
