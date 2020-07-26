public class _41_FirstMissingPositive {
    /**
     * Time O(n)
     * Space O(1)
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 1;
        for(int i = 0; i < nums.length; i++) {
            while(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    /**
     *
     */
    class Solution2 {
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;
            for(int i = 0; i < n; i++) {
                if(nums[i] <= 0 || nums[i] > n+1) {
                    nums[i] = n+1;
                }
            }
            for(int i = 0; i < n; i++) {
                int index = Math.abs(nums[i]);
                if(index <= n && nums[index - 1] > 0) {
                    nums[index - 1] *= -1;
                }
            }
            for(int i = 0; i < n; i++) {
                if(nums[i] > 0) {
                    return i + 1;
                }
            }
            return n + 1;
        }
    }
}
