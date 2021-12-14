import java.util.Arrays;

public class _1838_FrequencyoftheMostFrequentElement {
    class Solution {
        public int maxFrequency(int[] nums, int k) {
            Arrays.sort(nums);
            int res = 1, inc = 0;
            for(int i = 1, j = 0; i < nums.length; i++) {
                inc += (nums[i] - nums[i-1]) * (i - j);
                while(inc > k) {
                    inc -= nums[i] - nums[j++];
                }
                res = Math.max(res, i - j + 1);
            }
            return res;
        }
    }
}
