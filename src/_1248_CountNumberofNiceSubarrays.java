public class _1248_CountNumberofNiceSubarrays {
    class Solution {
        public int numberOfSubarrays(int[] nums, int k) {
            int res = 0, count = 0, n = nums.length;
            for (int i = 0, j = 0; i < n; i++) {
                if(nums[i] % 2 == 1) {
                    k--;
                    count = 0;
                }
                while(k == 0) {
                    if(nums[j++] % 2 == 1) {
                        k++;
                    }
                    count++;
                }
                res += count;
            }
            return res;
        }
    }
}
