public class _540_SingleElementinaSortedArray {
    class Solution {
        /**
         * Time O(logn)
         * Space O(1)
         * @param nums
         * @return
         */
        public int singleNonDuplicate(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while(left < right) {
                int mid = left + (right - left) / 2;
                if(mid % 2 == 1) {
                    mid--;
                }
                if(nums[mid] == nums[mid + 1]) {
                    left = mid + 2;
                } else {
                    right = mid;
                }
            }
            return nums[left];
        }
    }
}
