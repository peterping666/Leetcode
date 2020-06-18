public class _34_FindFirstLastPosition {

    /**
     * Time o(logn)
     * Space O(1)
     * @param nums
     * @param target
     * @return
     */
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

        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if(nums[left] == target) {
            return left;
        }
        if(nums[right] == target) {
            return right;
        }
        return -1;
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
