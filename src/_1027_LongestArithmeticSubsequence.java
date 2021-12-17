import java.util.HashMap;
import java.util.Map;

public class _1027_LongestArithmeticSubsequence {
    class Solution {
        public int longestArithSeqLength(int[] nums) {
            int n = nums.length, res = 2;
            Map<Integer, Integer>[] dp = new Map[n];

            for(int i = 0; i < n; i++) {
                dp[i] = new HashMap<>();
                for(int j = 0; j < i; j++) {
                    int diff = nums[i] - nums[j];
                    dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);
                    res = Math.max(res, dp[i].get(diff));
                }
            }
            return res;
        }
    }
}
