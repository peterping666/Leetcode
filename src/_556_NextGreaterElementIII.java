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

    class Solution2 {
        public int nextGreaterElement(int n) {
            char[] a = ("" + n).toCharArray();
            int i = a.length - 2;
            while (i >= 0 && a[i + 1] <= a[i]) {
                i--;
            }
            if (i < 0)
                return -1;
            int j = a.length - 1;
            while (j >= 0 && a[j] <= a[i]) {
                j--;
            }
            swap(a, i, j);
            reverse(a, i + 1);
            try {
                return Integer.parseInt(new String(a));
            } catch (Exception e) {
                return -1;
            }
        }
        private void reverse(char[] a, int start) {
            int i = start, j = a.length - 1;
            while (i < j) {
                swap(a, i, j);
                i++;
                j--;
            }
        }
        private void swap(char[] a, int i, int j) {
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
}
