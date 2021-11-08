import java.util.*;

public class _46_Permutations {
    /**
     * Time O(n! * n)
     * Space O(n!)
     */
    class Solution1 {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            helper(list, new ArrayList<>(), nums);
            return list;
        }

        private void helper(List<List<Integer>> list, List<Integer> path, int[] nums) {
            if(path.size() == nums.length) {
                list.add(new ArrayList<>(path));
                return;
            }
            for(int i = 0; i < nums.length; i++) {
                if(path.contains(nums[i])) continue;
                path.add(nums[i]);
                helper(list, path, nums);
                path.remove(path.size() - 1);
            }
        }
    }

    class Solution4 {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            helper(nums, new HashSet<>(), res, new ArrayList<>());
            return res;
        }

        private void helper(int[] nums, Set<Integer> set, List<List<Integer>> res, List<Integer> list) {
            if(list.size() == nums.length) {
                res.add(new ArrayList<>(list));
                return;
            }
            for(int i = 0; i < nums.length; i++) {
                if(set.add(nums[i])) {
                    list.add(nums[i]);
                    helper(nums, set, res, list);
                    list.remove(list.size() - 1);
                    set.remove(nums[i]);
                }
            }
        }
    }

    /**
     * Time O(n! - n! * n)
     * Space O(n!)
     */
    class Solution2 {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            helper(list, nums, 0);
            return list;
        }

        private void helper(List<List<Integer>> list, int[] nums, int start) {
            if(start == nums.length) {
                List<Integer> path = new ArrayList<>();
                for(int num : nums) {
                    path.add(num);
                }
                list.add(path);
            }
            for(int i = start; i < nums.length; i++) {
                swap(nums, start, i);
                helper(list, nums, start + 1);
                swap(nums, start, i);
            }
        }

        private void swap(int[] nums, int l, int r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
    }

    /**
     * Time O(n! - n * n!)
     * Space O(n!)
     */
    class Solution3 {
        public List<List<Integer>> permute(int[] nums) {
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
            for(int i = start; i < n; i++) {
                Collections.swap(path, start, i);
                helper(list, path, n, start + 1);
                Collections.swap(path, start, i);
            }
        }
    }
}
