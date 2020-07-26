public class _852_PeakIndexinaMountainArray {
    class Solution {
        public int peakIndexInMountainArray(int[] A) {
            int left = 0;
            int right = A.length - 1;
            while(left < right) {
                int mid = left + (right - left) / 2;
                if(A[mid] > A[mid + 1]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
}
