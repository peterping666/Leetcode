public class _189_RotateArray {
    /**
     * Time O(n)
     * Space O(1)
     */
    class Solution {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            k %= n;
            reverse(nums, 0, n-k-1);
            reverse(nums, n-k, n-1);
            reverse(nums, 0, n-1);
        }

        private void reverse(int[] nums, int left, int right) {
            while(left < right) {
                int tmp = nums[left];
                nums[left++] = nums[right];
                nums[right--] = tmp;
            }
        }
    }
}
