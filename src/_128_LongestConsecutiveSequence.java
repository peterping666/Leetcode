import java.util.HashSet;
import java.util.Set;

public class _128_LongestConsecutiveSequence {
    /**
     * Time O(n)
     * Space O(n)
     */
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for(int num : nums) {
                set.add(num);
            }
            int maxLen = 0;
            for(int num : nums) {
                if(set.remove(num)) {
                    int decrease = num;
                    int increase = num;
                    while(set.remove(increase + 1)) {
                        increase++;
                    }
                    while(set.remove(decrease - 1)) {
                        decrease--;
                    }
                    maxLen = Math.max(maxLen, increase - decrease + 1);
                }

            }
            return maxLen;
        }
    }
}
