public class _1712_WaystoSplitArrayIntoThreeSubarrays {

    class Solution {
        public int waysToSplit(int[] nums) {
            int n = nums.length;
            int[] preSum = new int[n];
            preSum[0] = nums[0];
            for(int i = 1; i < n; i++) {
                preSum[i] = preSum[i-1] + nums[i];
            }
            int res = 0, mod = (int)(1e9 + 7);
            for(int i = 0; i < n-2 && preSum[i] <= preSum[n-1]/3; i++) {
                int left = findLeft(preSum, i);
                int right = findRight(preSum, i);
                res = (res + right - left + 1) % mod;
            }
            return res;
        }

        private int findLeft(int[] preSum, int index) {
            int n = preSum.length, left = index + 1, right = n - 2, leftSum = preSum[index];
            while(left < right) {
                int mid = left + (right - left) / 2;
                int midSum = preSum[mid] - leftSum;
                if(midSum >= leftSum) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
        private int findRight(int[] preSum, int index) {
            int n = preSum.length, left = index + 1, right = n - 2, leftSum = preSum[index];
            while(left < right) {
                int mid = right - (right - left) / 2;
                int midSum = preSum[mid] - leftSum;
                int rightSum = preSum[n - 1] - leftSum - midSum;
                if(midSum <= rightSum) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return right;
        }
    }
}
