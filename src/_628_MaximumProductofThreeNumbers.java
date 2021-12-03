import java.util.Arrays;

public class _628_MaximumProductofThreeNumbers {
    class Solution {
        public int maximumProduct(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            return Math.max(nums[n-1]*nums[n-2]*nums[n-3], nums[n-1]*nums[0]*nums[1]);
        }
    }
}
