public class _55_JumpGame {
    class Solution {
        public boolean canJump(int[] nums) {
            int cur = 0;
            int next = 0;
            for(int i = 0; i < nums.length; i++) {
                if(cur < i) {
                    if(next == cur) {
                        return false;
                    }
                    cur = next;
                }
                next = Math.max(next, i + nums[i]);
            }
            return true;
        }
    }
}
