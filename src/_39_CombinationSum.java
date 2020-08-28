import java.util.ArrayList;
import java.util.List;

public class _39_CombinationSum {
    class Solution1 {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            helper(candidates, res, target, new ArrayList<>(), 0);
            return res;
        }

        private void helper(int[] candidates, List<List<Integer>> res, int target, List<Integer> path, int index) {
            if(target == 0) {
                res.add(new ArrayList<>(path));
                return;
            }
            if(target < 0 || index == candidates.length) {
                return;
            }
            for(int i = 0; candidates[index] * i <= target; i++) {
                for(int j = 0; j < i; j++) {
                    path.add(candidates[index]);
                }
                helper(candidates, res, target - candidates[index] * i, path, index + 1);
                for(int j = 0; j < i; j++) {
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    class Solution2 {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            helper(res, candidates, target, new ArrayList<>(), 0);
            return res;
        }

        private void helper(List<List<Integer>> res, int[] candidates,
                            int target, List<Integer> path, int index) {
            if(target == 0) {
                res.add(new ArrayList<>(path));
                return;
            }
            if(target < 0) return;
            for(int i = index; i < candidates.length; i++) {
                path.add(candidates[i]);
                helper(res, candidates, target - candidates[i], path, i);
                path.remove(path.size() - 1);
            }
        }
    }
}
