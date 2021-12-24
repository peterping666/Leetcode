public class _81_SearchRotatedSortedArrayII {

    class Solution {
        public boolean search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while(left < right && nums[left] == nums[right]) {
                right--;
            }
            while(left <= right) {
                int mid = left + (right - left) / 2;
                if(nums[mid] == target) {
                    return true;
                }
                if(nums[0] <= nums[mid] == nums[0] <= target) {
                    if(nums[mid] < target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else if(nums[mid] >= nums[0]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return false;
        }
    }
}
