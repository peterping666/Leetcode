public class _1712_WaystoSplitArrayIntoThreeSubarrays {
    class Solution {
        public int waysToSplit(int[] nums) {
            int n = nums.length;
            int[] prefixSum = new int[n + 1];
            for(int i = 1; i <= n; i++) {
                prefixSum[i] = prefixSum[i-1] + nums[i-1];
            }
            int res = 0;
            int mod = (int)(1e9 + 7);
            for(int i = 1; i < n; i++) {
                int leftSum = prefixSum[i];
                if(leftSum * 3 > prefixSum[n]) {
                    break;
                }
                int left = helper(prefixSum, i, true);
                int right = helper(prefixSum, i, false);
                if(left != -1 && right != -1) {
                    res = (res + right - left + 1) % mod;
                }
            }
            return res;
        }

        private int helper(int[] sums, int index, boolean searchLeft) {
            int left = index + 1, right = sums.length - 2, res = -1;
            int leftSum = sums[index];
            while(left <= right) {
                int mid = left + (right - left) / 2;
                int midSum = sums[mid] - leftSum;
                int rightSum = sums[sums.length - 1] - sums[mid];
                if(leftSum <= midSum && midSum <= rightSum) {
                    res = mid;
                    if(searchLeft) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else if(leftSum > midSum){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return res;
        }
    }
}
