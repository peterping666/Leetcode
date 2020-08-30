import java.util.ArrayDeque;
import java.util.Deque;

public class _1438_LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit {
    class Solution {
        public int longestSubarray(int[] nums, int limit) {
            Deque<Integer> maxd = new ArrayDeque<>();
            Deque<Integer> mind = new ArrayDeque<>();
            int slow = 0;
            int fast = 0;
            while (fast < nums.length) {
                while (!maxd.isEmpty() && nums[fast] > maxd.peekLast()) {
                    maxd.pollLast();
                }
                maxd.add(nums[fast]);

                while (!mind.isEmpty() && nums[fast] < mind.peekLast()) {
                    mind.pollLast();
                }
                mind.add(nums[fast]);

                if (maxd.peekFirst() - mind.peekFirst() > limit) {
                    if (maxd.peekFirst() == nums[slow]) {
                        maxd.pollFirst();
                    }
                    if (mind.peekFirst() == nums[slow]) {
                        mind.pollFirst();
                    }
                    slow++;
                }
                fast++;
            }
            return fast - slow;
        }
    }
}
