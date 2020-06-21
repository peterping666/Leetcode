public class _42_TrappingRainWater {
    /**
     * Time O(n)
     * Space O(1)
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int len = height.length;
        if(len == 0) return 0;
        int left = 0, right = len - 1;
        int leftMax = height[left], rightMax = height[right];
        int res = 0;
        while(left < right) {
            if(rightMax < leftMax) {
                right--;
                if(height[right] < rightMax) {
                    res += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
            } else {
                left++;
                if(height[left] < leftMax) {
                    res += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
            }
        }
        return res;
    }

    /**
     *
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int len = height.length;
        if(len == 0) return 0;
        int left = 0, right = len - 1;
        int leftMax = 0, rightMax = 0;
        int res = 0;
        while(left < right) {
            if(height[left] <= height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
