import java.util.ArrayList;
import java.util.List;

public class _254_FactorCombinations {
    /**
     * Time O(n^2)
     * @param n
     * @return
     */
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> lists = new ArrayList<>();
        dfs(lists, n, new ArrayList<>(), 2);
        return lists;
    }

    private void dfs(List<List<Integer>> lists, int n, List<Integer> path,
                     int start) {
        if(n == 1) {
            if(path.size() > 1){
                lists.add(new ArrayList<>(path));
            }
            return;
        }
        for(int i = start; i <= n; i++) {
            if(n % i == 0) {
                path.add(i);
                dfs(lists, n / i, path, i);
                path.remove(path.size() - 1);
            }
        }
    }
}
