public class _34_FindFirstLastPosition {

    class Solution1 {
        public int[] searchRange(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while(left <= right) {
                int mid = left + (right - left) / 2;
                if(nums[mid] == target) {
                    int start = mid;
                    int end = mid;
                    while(start - 1 >= 0 && nums[start - 1] == nums[mid]) {
                        start--;
                    }
                    while(end + 1 <= nums.length - 1 && nums[end + 1] == nums[mid]) {
                        end++;
                    }
                    return new int[]{start, end};
                } else if(nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return new int[]{-1,-1};
        }
    }

    class Solution2 {
        public int[] searchRange(int[] nums, int target) {
            if(nums == null || nums.length == 0) {
                return new int[]{-1,-1};
            }

            int start = findFirst(nums, target);
            int end = findLast(nums, target);
            return new int[]{start, end};
        }

        private int findFirst(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;

            while(left < right) {
                int mid = left + (right - left) / 2;
                if(nums[mid] == target) {
                    right = mid;
                } else if(nums[mid] > target){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return nums[left] == target ? left : -1;
        }

        private int findLast(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;

            while(left + 1 < right) {
                int mid = left + (right - left) / 2;
                if(nums[mid] <= target) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            if(nums[right] == target) {
                return right;
            }
            if(nums[left] == target) {
                return left;
            }
            return -1;
        }
    }
}
