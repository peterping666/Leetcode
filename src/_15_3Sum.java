import javafx.util.Pair;

import java.util.*;

public class _15_3Sum {
    /**
     * Time O(n^2)
     * Space O(logn - n)
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
            if (i == 0 || nums[i - 1] != nums[i])
                twoSumII(nums, i, res);
        return res;
    }
    void twoSumII(int[] nums, int i, List<List<Integer>> res) {
        int lo = i + 1, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (sum < 0 || (lo > i + 1 && nums[lo] == nums[lo - 1]))
                ++lo;
            else if (sum > 0 || (hi < nums.length - 1 && nums[hi] == nums[hi + 1]))
                --hi;
            else
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
        }
    }

    /**
     * Time O(n^2)
     * Space O(n^2)
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Pair> found = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            Set<Integer> seen = new HashSet<>();
            for (int j = i + 1; j < nums.length; ++j) {
                int complement = -nums[i] - nums[j];
                if (seen.contains(complement)) {
                    int v1 = Math.min(nums[i], Math.min(complement, nums[j]));
                    int v2 = Math.max(nums[i], Math.max(complement, nums[j]));
                    if (found.add(new Pair(v1, v2)))
                        res.add(Arrays.asList(nums[i], complement, nums[j]));
                }
                seen.add(nums[j]);
            }
        }
        return res;
    }
}
