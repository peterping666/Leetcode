public class _1539_KthMissingPositiveNumber {
    /**
     * case 1: arr have more than k missing positive nums, then find the index that >= missing nums
     * and index + k is the answer
     *
     * case2: arr doesn't have k missing pos nums, then find the len(arr) index, and len(arr) + k is the answer
     */
    class Solution {
        public int findKthPositive(int[] arr, int k) {
            int left = 0;
            int right = arr.length;
            while(left < right) {
                int mid = left + (right - left) / 2;
                if(arr[mid] - 1 - mid < k) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left + k;
        }
    }
}
