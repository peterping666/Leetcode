import java.util.HashSet;

public class _128_LongestConsecutiveSequence {
    class Solution {
        /**
         * Time O(n)
         * Space O(n)
         * @param nums
         * @return
         */
        public int longestConsecutive(int[] nums) {
            if(nums == null || nums.length == 0) {
                return 0;
            }
            HashSet<Integer> set = new HashSet<>();
            for(int num : nums) {
                set.add(num);
            }
            int res = 0;
            for(int num : nums) {
                int up = num + 1;
                while(set.contains(up)) {
                    set.remove(up);
                    up++;
                }
                int down = num - 1;
                while(set.remove(down)) {
                    set.remove(down);
                    down--;
                }
                res = Math.max(res, up - down - 1);
            }
            return res;
        }
    }
}
