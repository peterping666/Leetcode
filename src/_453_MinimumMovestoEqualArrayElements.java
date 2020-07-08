public class _453_MinimumMovestoEqualArrayElements {
    /**
     * Time O(n)
     * Space O(1)
     * @param nums
     * @return
     */
    public int minMoves1(int[] nums) {
        int min = nums[0];
        for(int num : nums) {
            min = Math.min(min, num);
        }
        int count = 0;
        for(int num : nums) {
            count += num - min;
        }
        return count;
    }

    /**
     *
     * @param nums
     * @return
     */
    public int minMoves2(int[] nums) {
        int min = nums[0];
        int sum = 0;
        for(int num : nums) {
            min = Math.min(min, num);
            sum += num;
        }
        return sum - min * nums.length;
    }
}
