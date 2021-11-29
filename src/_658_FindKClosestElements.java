import java.util.ArrayList;
import java.util.List;

public class _658_FindKClosestElements {
    /**
     * Time O(k + logn)
     */
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int left = 0, right = arr.length - k;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (x - arr[mid] > arr[mid + k] - x) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            List<Integer> res = new ArrayList<>();
            for(int i = left; i < left + k; i++) {
                res.add(arr[i]);
            }
            return res;
        }
    }

    /**
     * Time O(k + logn)
     */
    class Solution2 {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int left = largestSmallerEqual(arr, x);
            int right = left + 1;
            while(k-- > 0) {
                if(right >= arr.length ||
                        left >= 0 && Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                    left--;
                } else {
                    right++;
                }
            }
            List<Integer> res = new ArrayList<>();
            for(int i = left + 1; i < right; i++) {
                res.add(arr[i]);
            }
            return res;
        }

        private int largestSmallerEqual(int[] arr, int target) {
            int left = 0;
            int right = arr.length - 1;
            while(left <= right) {
                int mid = left + (right - left) / 2;
                if(arr[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return right;
        }


    }

}
