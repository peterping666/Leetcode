public class _33_SearchRotatedSortedArray {

    class Solution1 {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while(left <= right) {
                int mid = left + (right - left) / 2;
                if(nums[mid] == target) {
                    return mid;
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
            return -1;
        }
    }

    class Solution2 {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while(left <= right) {
                int mid = left + (right - left) / 2;
                if(nums[mid] == target) {
                    return mid;
                }
                if(nums[mid] >= nums[left]) {
                    if(nums[left] <= target && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }
}
