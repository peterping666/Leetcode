import java.util.LinkedList;
import java.util.Queue;

public class _487_MaxConsecutiveOnesII {
    /**
     * Time O(n)
     * Space O(1)
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes1(int[] nums) {
        boolean isSecond = false;
        int max = 0;
        int start = -1;
        for(int i = 0, j = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                if(isSecond) {
                    start = j;
                }
                j = i;
                isSecond = true;
            }
            max = Math.max(max, i - start);
        }
        return max;
    }

    /**
     * Time O(n)
     * Space O(1)
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes2(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        int max = 0;
        for(int i = 0, start = -1; i < nums.length; i++) {
            if(nums[i] == 0) {
                queue.offer(i);
            }
            if(queue.size() > 1) {
                start = queue.poll();
            }
            max = Math.max(max, i - start);
        }
        return max;
    }
}
