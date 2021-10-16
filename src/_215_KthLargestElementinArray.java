

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
            int pivotIndex = pivotIndex(left, right);
            swap(nums, pivotIndex, right);
            int pivot = nums[right];
            int leftBound = left;
            int rightBound = right - 1;
            while(leftBound <= rightBound) {
                if(nums[leftBound] <= pivot) {
                    leftBound++;
                } else if(nums[rightBound] >= pivot) {
                    rightBound--;
                } else {
                    swap(nums, leftBound++, rightBound--);
                }
            }
            swap(nums, leftBound, right);
            return leftBound;
        }

        private void swap(int[] nums, int left, int right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        private int pivotIndex(int left, int right) {
            return left + (int)(Math.random() * (right - left + 1));
        }
    }
}
