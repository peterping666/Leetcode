import java.util.ArrayList;
import java.util.List;

public class _78_Subsets {
    /**
     * Time O(n^k * n)
     * Space O(n)
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        helper(lists, nums, new ArrayList<>(), 0);
        return lists;
    }

    private void helper(List<List<Integer>> lists, int[] nums,
                        List<Integer> subset, int first) {
        lists.add(new ArrayList<>(subset));
        for(int i = first; i < nums.length; i++) {
            subset.add(nums[i]);
            helper(lists, nums, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }

    /**
     * Time O(2^n * n)
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
