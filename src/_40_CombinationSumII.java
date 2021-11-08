import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40_CombinationSumII {
    /**
     * Time O(2^n * n)
     * Space O(n)
     * @return
     */
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> lists = new ArrayList<>();
            Arrays.sort(candidates);
            helper(lists, new ArrayList<>(), 0, candidates, target);
            return lists;
        }

        private void helper(List<List<Integer>> lists, List<Integer> path,
                            int start, int[] candidates, int target) {
            if(target == 0) {
                lists.add(new ArrayList<>(path));
                return;
            }
            if(target < 0) return;
            for(int i = start; i < candidates.length; i++) {
                if(i != start && candidates[i - 1] == candidates[i]) continue;
                path.add(candidates[i]);
                helper(lists, path, i + 1, candidates, target - candidates[i]);
                path.remove(path.size() - 1);
            }
        }
    }


}
