import java.util.*;

public class _47_PermutationsII {
    /**
     * Time O(n!)
     * Space O(n!)
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique1(int[] nums) {
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

    /**
     * Time O(n!)
     * Space O(n)
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        helper(list, new ArrayList<>(), nums, used);
        return list;
    }

    private void helper(List<List<Integer>> list,
                        List<Integer> path,
                        int[] nums, boolean[] used) {
        if(path.size() == nums.length) {
            list.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            path.add(nums[i]);
            helper(list, path, nums, used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
