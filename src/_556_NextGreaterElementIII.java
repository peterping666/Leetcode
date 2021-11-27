public class _556_NextGreaterElementIII {
    /**
     * Time O(n)
     * Space O(n)
     */

    class Solution {
        public int nextGreaterElement(int n) {
            if(n < 10) {
                return -1;
            }
            char[] arr = String.valueOf(n).toCharArray();
            int index = arr.length - 2;
            while(index >= 0 && arr[index] >= arr[index + 1]) {
                index--;
            }
            if(index == -1) {
                return -1;
            }
            int idx = arr.length - 1;
            while(idx >= 0 && arr[idx] <= arr[index]) {
                idx--;
            }
            swap(arr, index, idx);
            reverse(arr, index + 1);
            long res = Long.valueOf(new String(arr));
            return res > Integer.MAX_VALUE ? -1 : (int) res;
        }

        private void swap(char[] arr, int left, int right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
        }

        private void reverse(char[] arr, int start) {
            int left = start;
            int right = arr.length - 1;
            while(left < right) {
                swap(arr, left++, right--);
            }
        }
    }
}
