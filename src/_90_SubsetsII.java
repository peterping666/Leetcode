import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _90_SubsetsII {
    /**
     * Time O(2^n * n)
     * Space O(n)
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        helper(lists, nums, new ArrayList<>(), 0);
        return lists;
    }

    private void helper(List<List<Integer>> lists, int[] nums,
                        List<Integer> subset, int first) {
        lists.add(new ArrayList<>(subset));
        for(int i = first; i < nums.length; i++) {
            if(i != first && nums[i - 1] == nums[i]) continue;
            subset.add(nums[i]);
            helper(lists, nums, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
