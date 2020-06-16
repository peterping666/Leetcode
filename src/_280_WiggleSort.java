import java.util.Arrays;

public class _280_WiggleSort {
    /**
     * Time O(nlogn)
     * Space O(1)
     * @param nums
     */
    public void wiggleSort1(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length - 1; i += 2) {
            swap(nums, i, i + 1);
        }
    }

    /**
     * Time O(n)
     * Space O(1)
     * @param nums
     */
    public void wiggleSort2(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i ++) {
            if(((i % 2 == 0) && nums[i] > nums[i + 1])
                    || ((i % 2 == 1) && nums[i] < nums[i + 1])) {
                swap(nums, i, i + 1);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
