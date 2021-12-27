public class _1567_MaximumLengthofSubarrayWithPositiveProduct {
    class Solution {
        public int getMaxLen(int[] nums) {
            int n = nums.length, res = 0, count = 0;
            for(int i = 0, j = 0, k = n; i < n; i++) {
                if(nums[i] == 0) {
                    j = i + 1;
                    count = 0;
                    k = n;
                    continue;
                }
                if(nums[i] < 0) {
                    count++;
                    if(k == n) {
                        k = i;
                    }
                }
                if(count % 2 == 0) {
                    res = Math.max(res, i - j + 1);
                } else {
                    res = Math.max(res, i - k);
                }
            }
            return res;
        }
    }
}
