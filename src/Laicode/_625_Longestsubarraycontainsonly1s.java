package Laicode;

public class _625_Longestsubarraycontainsonly1s {
    public class Solution {
        public int longestConsecutiveOnes(int[] nums, int k) {
            int count = 0;
            for(int i = 0, j = 0; i < nums.length; i++) {
                if(nums[i] != 1) {
                    k--;
                }
                while(k < 0) {
                    if(nums[j] == 0) {
                        k++;
                    }
                    j++;
                }
                count = Math.max(count, i - j + 1);
            }
            return count;
        }
    }

}
