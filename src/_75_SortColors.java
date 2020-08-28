public class _75_SortColors {

    /**
     * Time O(n)
     * Space O(1)
     * @param nums
     */
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        for(int i = 0; i <= right; i++) {
            if(nums[i] == 0) {
                swap(nums, i, left++);
            }
            if(nums[i] == 2) {
                swap(nums, i--, right--);
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
