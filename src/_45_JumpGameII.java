public class _45_JumpGameII {
    class Solution {
        public int jump(int[] nums) {
            int count = 0;
            int next = 0;
            int cur = 0;
            for(int i = 0; i < nums.length; i++) {
                if(i > cur) {
                    if(cur == next) {
                        return -1;
                    }
                    count++;
                    cur = next;
                }
                next = Math.max(next, i + nums[i]);
            }
            return count;
        }
    }
}
