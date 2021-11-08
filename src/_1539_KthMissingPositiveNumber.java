public class _1539_KthMissingPositiveNumber {
    /**
     *  A[i] - (i + 1) will be # of missing positives at index i
     */
    class Solution {
        public int findKthPositive(int[] arr, int k) {
            int left = 0;
            int right = arr.length;
            while(left < right) {
                int mid = left + (right - left) / 2;
                if(arr[mid] - mid - 1 < k) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left + k;
        }
    }
}
