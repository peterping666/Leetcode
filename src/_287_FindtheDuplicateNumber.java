public class _287_FindtheDuplicateNumber {
    /**
     * Time O(nlog(n))
     * Space O(1)
     * @return
     */
    class Solution {
        public int findDuplicate(int[] nums) {
            int left = 1;
            int right = nums.length - 1;
            while(left < right) {
                int mid = left + (right - left) / 2;
                int count = 0;
                for(int i = 0; i < nums.length; i++) {
                    if(nums[i] <= mid) {
                        count++;
                    }
                }
                if(count <= mid) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }

    /**
     * Time O(n)
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while(fast != slow);

        int slow2 = nums[0];
        while(slow2 != slow) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }
        return slow;
    }
}
