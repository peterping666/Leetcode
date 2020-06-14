public class _26_RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;
        while(fast < nums.length) {
            while(fast < nums.length && nums[fast] == nums[slow]) {
                fast++;
            }
            if(fast < nums.length) {
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
