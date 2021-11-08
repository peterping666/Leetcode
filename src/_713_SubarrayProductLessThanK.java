public class _713_SubarrayProductLessThanK {
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int prod = 1;
            int res = 0;
            for(int i = 0, j = 0; i < nums.length; i++) {
                prod *= nums[i];
                while(j <= i && prod >= k) {
                    prod /= nums[j++];
                }
                res += i - j + 1;
            }
            return res;
        }
    }   
}
