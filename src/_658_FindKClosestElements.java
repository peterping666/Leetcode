import java.util.LinkedList;
import java.util.List;

public class _658_FindKClosestElements {
    class Solution1 {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            LinkedList<Integer> res = new LinkedList<>();
            int left = 0;
            int right = arr.length - 1;
            while(left + 1 < right) {
                int mid = left + (right - left) / 2;
                if(arr[mid] < x) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            while(res.size() < k) {
                if(left < 0 || right < arr.length && Math.abs(arr[right] - x) < Math.abs(arr[left] - x)) {
                    res.add(arr[right++]);
                } else {
                    res.addFirst(arr[left--]);
                }
            }
            return res;
        }
    }

    public class Solution2 {
        public int[] kClosest(int[] array, int target, int k) {
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
}
