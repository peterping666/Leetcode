public class _283_MoveZeroes {

    // Operations: nums.length
    public void moveZeroes1(int[] nums) {
        int slow = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[slow++] = nums[i];
            }
        }
        while(slow < nums.length) {
            nums[slow++] = 0;
        }
    }


    // Operations: 2 * #non-zero
    public void moveZeroes2(int[] nums) {
        for(int i = 0, j = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }
}
