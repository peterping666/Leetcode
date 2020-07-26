public class _1060_MissingElementinSortedArray {
    class Solution {
        public int missingElement(int[] nums, int k) {
            int n = nums.length;
            if(k > missing(nums, n-1)) {
                return nums[n - 1] + k - missing(nums, n - 1);
            }
            int left = 0;
            int right = n - 1;
            while(left < right) {
                int mid = left + (right - left) / 2;
                int missingNum = missing(nums, mid);
                if(missingNum < k) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return nums[left-1] + k - missing(nums, left - 1);
        }

        private int missing(int[] nums, int idx) {
            return nums[idx] - nums[0] - idx;
        }
    }
}
