public class _136_SingleNumber {
    /**
     * Time O(n)
     * Space O(1)
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        for(int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}
