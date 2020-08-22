public class _41_FirstMissingPositive {
    /**
     * Time O(n)
     * Space O(1)
     * @return
     */
    class Solution {
        public int firstMissingPositive(int[] nums) {
            for(int i = 0; i < nums.length; i++) {
                while(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                    swap(nums, i, nums[i] - 1);
                }
            }
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] != i + 1) {
                    return i + 1;
                }
            }
            return nums.length + 1;
        }

        private void swap(int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
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
