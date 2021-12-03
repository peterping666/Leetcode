public class _1539_KthMissingPositiveNumber {

    class Solution {
        public int findKthPositive(int[] arr, int k) {
            int left = 0, right = arr.length - 1;
            while(left < right) {
                int mid = right - (right - left) / 2;
                if(numMis(arr, mid) < k) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            int mis = numMis(arr, left);
            if(mis < k) {
                return arr[left] + k - mis;
            }
            return k;
        }
        private int numMis(int[] nums, int i) {
            return nums[i] - i - 1;
        }
    }
}
