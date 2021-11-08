import java.util.*;

public class _47_PermutationsII {

    /**
     * Time O(n!)
     * Space O(n)
     */
    class Solution1 {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            helper(res, new ArrayList<>(), nums, new boolean[nums.length]);
            return res;
        }

        private void helper(List<List<Integer>> res,
                            List<Integer> path,
                            int[] nums, boolean[] used) {
            if(path.size() == nums.length) {
                res.add(new ArrayList<>(path));
                return;
            }
            for(int i = 0; i < nums.length; i++) {
                if(used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                used[i] = true;
                path.add(nums[i]);
                helper(res, path, nums, used);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    /**
     * Time O(n!)
     * Space O(n)
     */
    class Solution2 {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            for(int num : nums) {
                path.add(num);
            }
            helper(list, path, nums.length, 0);
            return list;
        }

        private void helper(List<List<Integer>> list, List<Integer> path, int n, int start) {
            if(start == n) {
                list.add(new ArrayList<>(path));
            }
            HashSet<Integer> seen = new HashSet<>();
            for(int i = start; i < n; i++) {
                if(seen.add(path.get(i))) {
                    Collections.swap(path, start, i);
                    helper(list, path, n, start + 1);
                    Collections.swap(path, start, i);
                }
            }
        }
    }
}
