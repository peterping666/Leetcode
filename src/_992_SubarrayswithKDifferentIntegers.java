import java.util.HashMap;
import java.util.Map;

public class _992_SubarrayswithKDifferentIntegers {
    class Solution {
        public int subarraysWithKDistinct(int[] nums, int k) {
            return atMost(nums, k) - atMost(nums, k - 1);
        }

        private int atMost(int[] nums, int k) {
            int res = 0, n = nums.length;
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0, j = 0; i < n; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                while(map.size() > k) {
                    map.put(nums[j], map.get(nums[j]) - 1);
                    if(map.get(nums[j]) == 0) {
                        map.remove(nums[j]);
                    }
                    j++;
                }
                res += i - j + 1;
            }
            return res;
        }
    }
}
