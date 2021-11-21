public class _34_FindFirstLastPosition {

    class Solution {

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

            while(left < right) {
                int mid = left + (right - left + 1) / 2;
                if(nums[mid] == target) {
                    left = mid;
                } else if(nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return nums[right] == target ? left : -1;
        }
    }
}
