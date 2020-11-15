import java.util.ArrayDeque;
import java.util.Deque;

public class _1438_LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit {
    class Solution {
        public int longestSubarray(int[] nums, int limit) {
            Deque<Integer> max = new ArrayDeque<>();
            Deque<Integer> min = new ArrayDeque<>();
            int left = 0;
            int right = 0;
            while(right < nums.length) {
                while(!max.isEmpty() && max.peekLast() < nums[right]) {
                    max.pollLast();
                }
                max.offerLast(nums[right]);

                while(!min.isEmpty() && min.peekLast() > nums[right]) {
                    min.pollLast();
                }
                min.offerLast(nums[right]);

                if(max.peekFirst() - min.peekFirst() > limit) {
                    if(max.peekFirst() == nums[left]) {
                        max.pollFirst();
                    }
                    if(min.peekFirst() == nums[left]) {
                        min.pollFirst();
                    }
                    left++;
                }
                right++;
            }
            return right - left;
        }
    }
}
