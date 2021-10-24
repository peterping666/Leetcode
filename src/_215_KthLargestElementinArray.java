

public class _215_KthLargestElementinArray {
    class Solution1 {
        public int findKthLargest(int[] nums, int k) {
            int left = 0;
            int right = nums.length - 1;
            while(left < right) {
                int pivotIndex = partition(nums, left, right);
                if(pivotIndex == nums.length - k) {
                    return nums[pivotIndex];
                } else if(pivotIndex > nums.length - k) {
                    right = pivotIndex - 1;
                } else {
                    left = pivotIndex + 1;
                }
            }
            return nums[left];
        }

        private int partition(int[] nums, int left, int right) {
            int pivotIndex = getPivotIndex(left, right);
            int pivot = nums[pivotIndex];
            swap(nums, pivotIndex, right);
            int start = left;
            int end = right - 1;
            while(start <= end) {
                if(nums[start] <= pivot) {
                    start++;
                } else if(nums[end] > pivot) {
                    end--;
                } else {
                    swap(nums, start++, end--);
                }
            }
            swap(nums, start, right);
            return start;
        }

        private void swap(int[] nums, int left, int right) {
            int tmp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = tmp;
        }

        private int getPivotIndex(int left, int right) {
            return left + ((int)(Math.random() * (right - left + 1)));
        }
    }
}
