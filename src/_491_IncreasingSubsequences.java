import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _491_IncreasingSubsequences {
    /**
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        helper(nums, set, new ArrayList<>(), 0);
        List lists = new ArrayList<>(set);
        return lists;
    }

    private void helper(int[] nums, HashSet<List<Integer>> set,
                        List<Integer> path, int start) {
        if(path.size() >= 2) {
            set.add(new ArrayList<>(path));
        }
        for(int i = start; i < nums.length; i++) {
            if(!path.isEmpty() && path.get(path.size() - 1) > nums[i]) continue;
            path.add(nums[i]);
            helper(nums, set, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
