import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_3Sum {
    /**
     * Time O(n^2)
     * Space O(logn / n)
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
}
