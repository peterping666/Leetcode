import java.util.ArrayList;
import java.util.List;

public class _78_Subsets {
    /**
     * Time O(n * 2^n)
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
}
