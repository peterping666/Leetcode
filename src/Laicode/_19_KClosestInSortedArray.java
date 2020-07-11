package Laicode;

public class _19_KClosestInSortedArray {
    public class Solution {
        public int[] kClosest(int[] array, int target, int k) {
            // Write your solution here
            if(array == null || array.length == 0 || k == 0) {
                return new int[0];
            }
            int left = largestSmallerEqual(array, target);
            int right = left + 1;
            int[] res = new int[k];
            for(int i = 0; i < k; i++) {
                if(right >= array.length ||
                        left >= 0 && Math.abs(array[left] - target) <= Math.abs(array[right] - target)) {
                    res[i] = array[left--];
                } else {
                    res[i] = array[right++];
                }
            }
            return res;
        }
        private int largestSmallerEqual(int[] array, int target) {
            int left = 0;
            int right = array.length - 1;
            while(left <= right) {
                int mid = left + (right - left) / 2;
                if(array[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return right;
        }
    }

// find the largest number which is smaller or equal to target,
// then explore numbers on both left and right sides.
//
}
