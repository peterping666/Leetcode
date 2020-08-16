import javafx.util.Pair;

import java.util.*;

public class _15_3Sum {
    /**
     * Time O(n^2)
     * Space O(logn - n)
     * @return
     */
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            for(int i = 0; i < nums.length; i++) {
                if(i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int left = i + 1;
                int right = nums.length - 1;
                while(left < right) {
                    int sum = nums[left] + nums[right] + nums[i];
                    if(sum < 0 || left > i + 1 && nums[left] == nums[left - 1]) {
                        left++;
                    } else if(sum > 0 || right < nums.length - 1 && nums[right] == nums[right + 1]) {
                        right--;
                    } else {
                        res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                        left++;
                        right--;
                    }
                }
            }
            return res;
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
