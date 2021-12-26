import java.util.ArrayDeque;
import java.util.Deque;

public class _1438_LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit {

    class Solution1 {
        public int longestSubarray(int[] nums, int limit) {
            Deque<Integer> max = new ArrayDeque<>();
            Deque<Integer> min = new ArrayDeque<>();
            int res = 0;
            for(int i = 0, j = 0; i < nums.length; i++) {
                while(!max.isEmpty() && max.peekLast() < nums[i]) {
                    max.pollLast();
                }
                while(!min.isEmpty() && min.peekLast() > nums[i]) {
                    min.pollLast();
                }
                max.offerLast(nums[i]);
                min.offerLast(nums[i]);
                while(!max.isEmpty() && !min.isEmpty() && max.peekFirst() - min.peekFirst() > limit) {
                    if(max.peekFirst() == nums[j]) {
                        max.pollFirst();
                    }
                    if(min.peekFirst() == nums[j]){
                        min.pollFirst();
                    }
                    j++;
                }
                res = Math.max(res, i - j + 1);
            }
            return res;
        }
    }

    class Solution2 {
        public int longestSubarray(int[] nums, int limit) {
            Deque<Integer> max = new ArrayDeque<>();
            Deque<Integer> min = new ArrayDeque<>();
            int res = 0;
            for(int i = 0, j = 0; i < nums.length; i++) {
                while(!max.isEmpty() && max.peekLast() < nums[i]) {
                    max.pollLast();
                }
                while(!min.isEmpty() && min.peekLast() > nums[i]) {
                    min.pollLast();
                }
                max.offerLast(nums[i]);
                min.offerLast(nums[i]);
                if(max.peekFirst() - min.peekFirst() > limit) {
                    if(max.peekFirst() == nums[j]) {
                        max.pollFirst();
                    }
                    if(min.peekFirst() == nums[j]){
                        min.pollFirst();
                    }
                    j++;
                }
                res = Math.max(res, i - j + 1);
            }
            return res;
        }
    }
}
