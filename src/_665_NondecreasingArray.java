public class _665_NondecreasingArray {
    class Solution {
        public boolean checkPossibility(int[] nums) {
            int count = 0;
            for(int i = 0; i < nums.length - 1 && count <= 1; i++) {
                if(nums[i] > nums[i+1]) {
                    count++;
                    if(i > 0 && nums[i+1] < nums[i-1]) {
                        nums[i+1] = nums[i];
                    }
                }
            }
            return count <= 1;
        }
    }
}
