import java.util.ArrayList;
import java.util.List;

public class _78_Subsets {
    /**
     * Time O(n! * n) or O(2^n * n)
     * Space O(n)
     */
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            helper(res, nums, new ArrayList<>(), 0);
            return res;
        }

        private void helper(List<List<Integer>> res, int[] nums,
                            List<Integer> subset, int first) {
            res.add(new ArrayList<>(subset));
            for(int i = first; i < nums.length; i++) {
                subset.add(nums[i]);
                helper(res, nums, subset, i + 1);
                subset.remove(subset.size() - 1);
            }
        }
    }

    /**
     * Time O(2^n * n) - 2^n subsets and O(n) to create new list for each subset
     * Space O(n)
     */
    class Solution2 {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            helper(nums, res, 0, new ArrayList<>());
            return res;
        }

        private void helper(int[] nums, List<List<Integer>> res, int index, List<Integer> path) {
            if(index == nums.length) {
                res.add(new ArrayList<>(path));
                return;
            }
            path.add(nums[index]);
            helper(nums, res, index + 1, path);
            path.remove(path.size() - 1);
            helper(nums, res, index + 1, path);
        }
    }
}
