public class _45_JumpGameII {
    class Solution {
        public int jump(int[] nums) {
            int res = 0;
            for(int i = 0, cur = 0, max = 0; i < nums.length; i++) {
                if(cur > max) {
                    return -1;
                }

                if(i > cur) {
                    res++;
                    cur = max;
                }
                max = Math.max(max, i + nums[i]);
            }
            return res;
        }
    }
}
