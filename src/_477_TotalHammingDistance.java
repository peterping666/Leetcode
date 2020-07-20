public class _477_TotalHammingDistance {
    class Solution {
        public int totalHammingDistance(int[] nums) {
            int res = 0;
            int len = nums.length;
            for(int i = 0; i < 32; i++) {
                int count = 0;
                for(int j = 0; j < len; j++) {
                    count += (nums[j] >> i) & 1;
                }
                res += count * (len - count);
            }
            return res;
        }
    }
}
