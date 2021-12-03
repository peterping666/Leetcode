public class _1060_MissingElementinSortedArray {
    class Solution {
        public int missingElement(int[] nums, int k) {
            int left = 0, right = nums.length - 1;
            while(left < right) {
                int mid = right - (right - left) / 2;
                if(numMis(nums, mid) < k) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return nums[left] + k - (numMis(nums, left));
        }

        private int numMis(int[] nums, int i) {
            return nums[i] - nums[0] - i;
        }
    }
}
