public class _410_SplitArrayLargestSum {
    /**
     * Time: nlog(sum(nums))
     */
    class Solution {
        public int splitArray(int[] nums, int m) {
            int left = 0, right = 0;
            for(int num : nums) {
                left = Math.max(left, num);
                right += num;
            }

            while(left < right) {
                int mid = left + (right - left) / 2;
                if(valid(nums, mid, m)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            return left;
        }

        private boolean valid(int[] nums, int max, int m) {
            int count = 0, sum = 0;
            for(int i = 0; i < nums.length - 1; i++) {
                sum += nums[i];
                if(sum + nums[i+1] > max) {
                    sum = 0;
                    count++;
                }
            }

            return count + 1 <= m;
        }
    }
}
