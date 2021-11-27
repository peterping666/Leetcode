public class _268_MissingNumber {
    class Solution {
        public int missingNumber(int[] nums) {
            int n = nums.length;
            int ans = n;
            for(int i = 0; i < n; i++) {
                ans ^= i;
                ans ^= nums[i];
            }
            return ans;
        }
    }
}
