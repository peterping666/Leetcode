public class _698_PartitiontoKEqualSumSubsets {
    class Solution {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            int sum = 0;
            int maxNum = 0;
            for(int num : nums) {
                sum += num;
                maxNum = Math.max(maxNum, num);
            }
            if(sum % k != 0 || nums.length < k || maxNum > sum / k) {
                return false;
            }
            return helper(nums, k, sum / k, new boolean[nums.length], 0, 0);
        }

        private boolean helper(int[] nums, int k, int target, boolean[] visited, int curSum, int index) {
            if(k == 0) {
                return true;
            }
            if(curSum == target) {
                return helper(nums, k - 1, target, visited, 0, 0);
            }
            for(int i = index; i < nums.length; i++) {
                if(!visited[i] && curSum + nums[i] <= target) {
                    visited[i] = true;
                    if(helper(nums, k, target, visited, curSum + nums[i], i + 1)) {
                        return true;
                    }
                    visited[i] = false;
                }
            }
            return false;
        }
    }
}
