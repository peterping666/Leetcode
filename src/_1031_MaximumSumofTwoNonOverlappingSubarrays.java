public class _1031_MaximumSumofTwoNonOverlappingSubarrays {
    class Solution {
        public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
            for (int i = 1; i < nums.length; ++i) {
                nums[i] += nums[i - 1];
            }
            int res = nums[firstLen + secondLen - 1];
            int firstMax = nums[firstLen - 1];
            int secondMax = nums[secondLen - 1];
            for (int i = firstLen + secondLen; i < nums.length; ++i) {
                firstMax = Math.max(firstMax, nums[i - secondLen] - nums[i -firstLen - secondLen]);
                secondMax = Math.max(secondMax, nums[i - firstLen] - nums[i - firstLen - secondLen]);
                res = Math.max(res, Math.max(firstMax + nums[i] - nums[i - secondLen], secondMax + nums[i] - nums[i - firstLen]));
            }
            return res;
        }
    }
}
