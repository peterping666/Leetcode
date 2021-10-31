public class _42_TrappingRainWater {
    /**
     * Time O(n)
     * Space O(1)
     */
    class Solution {
        public int trap(int[] height) {
            if(height.length == 0) {
                return 0;
            }
            int res = 0;
            int left = 0;
            int right = height.length - 1;
            int leftMax = height[left];
            int rightMax = height[right];
            while(left < right) {
                if(leftMax < rightMax) {
                    left++;
                    if(height[left] < leftMax) {
                        res += leftMax - height[left];
                    } else {
                        leftMax = height[left];
                    }
                } else {
                    right--;
                    if(height[right] < rightMax) {
                        res += rightMax - height[right];
                    } else {
                        rightMax = height[right];
                    }
                }
            }
            return res;
        }
    }
}
