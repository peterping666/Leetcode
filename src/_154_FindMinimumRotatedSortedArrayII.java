public class _154_FindMinimumRotatedSortedArrayII {

    /**
     * Time O(logn - n)
     * Space O(1)
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == nums[right]) {
                right--;
                continue;
            }
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
