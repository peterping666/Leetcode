public class _1004_MaxConsecutiveOnesIII {
    class Solution {
        public int longestOnes(int[] nums, int k) {
            int res = 0;
            for(int i = 0, j = 0; i < nums.length; i++) {
                if(nums[i] == 0) {
                    k--;
                    while(k < 0) {
                        if(nums[j++] == 0) {
                            k++;
                        }
                    }
                }
                res = Math.max(res, i - j + 1);
            }
            return res;
        }
    }
}
