import java.util.ArrayList;
import java.util.List;

public class _39_CombinationSum {
    /**
     * Time O()
     * Space O()
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        helper(lists, candidates, target, new ArrayList<>(), 0);
        return lists;
    }

    private void helper(List<List<Integer>> lists, int[] candidates,
                        int target, List<Integer> path, int start) {
        if(target == 0) {
            lists.add(new ArrayList<>(path));
            return;
        }
        if(target < 0) return;
        for(int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            helper(lists, candidates, target - candidates[i], path, i);
            path.remove(path.size() - 1);
        }
    }
}
