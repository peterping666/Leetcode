public class _80_RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 3) return nums.length;
        int slow = 2, fast = 2;
        while(fast < nums.length) {
            if(nums[fast] != nums[slow - 2]) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }
}
