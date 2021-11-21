public class _55_JumpGame {
    class Solution {
        public boolean canJump(int[] nums) {
            int next = 0, n = nums.length;
            for(int i = 0; i < n; i++) {
                if(i > next) {
                    return false;
                }
                next = Math.max(next, i + nums[i]);
                if(next >= n - 1) {
                    return true;
                }
            }
            return true;
        }
    }
}
