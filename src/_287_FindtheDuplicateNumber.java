public class _287_FindtheDuplicateNumber {
    /**
     * Time O(nlog(n))
     * Space O(1)
     * @param nums
     * @return
     */
    public int findDuplicate1(int[] nums) {
        int min = 1;
        int max = nums.length - 1;
        while(min < max) {
            int mid = min + (max - min) / 2;
            int count = 0;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] <= mid) {
                    count++;
                }
            }
            if(count > mid) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
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
