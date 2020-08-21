import java.util.Arrays;

public class _31_NextPermutation {
    class Solution {
        public void nextPermutation(int[] nums) {
            int n = nums.length;
            if(n <= 1) {
                return;
            }
            int index = -1;
            for(int i = n - 2; i >= 0; i--) {
                if(nums[i] < nums[i + 1]) {
                    index = i;
                    break;
                }
            }
            if(index == -1) {
                reverse(nums, 0, n - 1);
                return;
            }
            int right = n - 1;
            while(nums[right] <= nums[index]) {
                right--;
            }
            swap(nums, index, right);
            Arrays.sort(nums, index + 1, n);
        }

        private void swap(int[] nums, int left, int right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }

        private void reverse(int[] nums, int left, int right) {
            while(left < right) {
                swap(nums, left++, right--);
            }
        }
    }
}
