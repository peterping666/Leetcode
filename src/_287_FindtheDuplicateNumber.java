public class _287_FindtheDuplicateNumber {

    class Solution1 {
        public int findDuplicate(int[] nums) {
            int n = nums.length;
            for(int i = 0; i < n; i++) {
                while(nums[i] <= n && nums[i] != nums[nums[i]-1]) {
                    swap(nums, i, nums[i] - 1);
                }
            }
            for(int i = 0; i <= n; i++) {
                if(nums[i] != i + 1) {
                    return nums[i];
                }
            }
            return -1;
        }

        private void swap(int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }

    class Solution2 {
        public int findDuplicate(int[] nums) {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while(slow != fast) {
                fast = nums[nums[fast]];
                slow = nums[slow];
            }
            slow = 0;
            while(fast != slow) {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
    }
}
