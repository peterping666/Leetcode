public class _287_FindtheDuplicateNumber {
    class Solution {
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
