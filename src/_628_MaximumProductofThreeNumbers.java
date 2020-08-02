import java.util.Arrays;

public class _628_MaximumProductofThreeNumbers {
    class Solution1 {
        public int maximumProduct(int[] nums) {
            Arrays.sort(nums);
            return Math.max(nums[0] * nums[1] * nums[nums.length - 1],
                    nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
        }
    }

    class Solution2 {
        public int maximumProduct(int[] nums) {
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
            for(int num : nums) {
                if(min1 > num) {
                    min2 = min1;
                    min1 = num;
                } else if(min2 > num) {
                    min2 = num;
                }
                if(max1 < num) {
                    max3 = max2;
                    max2 = max1;
                    max1 = num;
                } else if(max2 < num) {
                    max3 = max2;
                    max2 = num;
                } else if(max3 < num) {
                    max3 = num;
                }
            }
            return Math.max(min1 * min2 * max1, max1 * max2 * max3);
        }
    }
}
