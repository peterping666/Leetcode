public class _169_MajorityElement {

    class Solution {
        public int majorityElement(int[] nums) {
            int res = nums[0];
            int count = 1;
            for(int i = 1; i < nums.length; i++) {
                if(res == nums[i]) {
                    count++;
                } else if(--count == 0) {
                    res = nums[i];
                    count = 1;
                }
            }
            return res;
        }
    }
}
