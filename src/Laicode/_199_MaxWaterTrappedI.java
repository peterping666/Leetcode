package Laicode;

public class _199_MaxWaterTrappedI {
    public class Solution {
        public int maxTrapped(int[] array) {
            int leftMax = Integer.MIN_VALUE;
            int rightMax = Integer.MIN_VALUE;
            int left = 0;
            int right = array.length - 1;
            int maxWater = 0;
            while(left <= right) {
                if(leftMax <= rightMax) {
                    leftMax = Math.max(leftMax, array[left]);
                    maxWater += leftMax - array[left];
                    left++;
                } else {
                    rightMax = Math.max(rightMax, array[right]);
                    maxWater += rightMax - array[right];
                    right--;
                }
            }
            return maxWater;
        }
    }

}
