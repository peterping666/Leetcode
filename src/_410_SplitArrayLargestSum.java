public class _410_SplitArrayLargestSum {
    class Solution {
        public int splitArray(int[] nums, int m) {
            int max = 0;
            int sum = 0;
            for(int num : nums) {
                max = Math.max(max, num);
                sum += num;
            }
            int left = max;
            int right = sum;
            while(left < right) {
                int mid = left + (right - left) / 2;
                int count = 1;
                int curSum = 0;
                for(int num : nums) {
                    if(curSum + num > mid) {
                        count++;
                        curSum = 0;
                    }
                    curSum += num;
                }
                if(count > m) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }
}
