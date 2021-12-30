public class _493_ReversePairs {
    /**
     * Time O(n logn logn)
     */
    class Solution {
        public int reversePairs(int[] nums) {
            int n = nums.length;
            Node[] arr = new Node[n];
            for(int i = 0; i < n; i++) {
                arr[i] = new Node(nums[i], i);
            }
            int[] res = new int[1];
            mergeSort(arr, 0, n-1, new Node[n], res);
            return res[0];
        }

        private void mergeSort(Node[] arr, int left, int right, Node[] buffer, int[] res) {
            if(left >= right) {
                return;
            }
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid, buffer, res);
            mergeSort(arr, mid + 1, right, buffer, res);
            merge(arr, left, mid, right, buffer, res);
        }

        private void merge(Node[] arr, int left, int mid, int right, Node[] buffer, int[] res) {
            int i = left, j = mid + 1, index = left, cnt = 0;
            for(int k = left; k <= mid; k++) {
                int idx = search(arr, mid+1, right, arr[k].val);
                res[0] += idx - mid;
            }
            while(i <= mid && j <= right) {
                if(arr[i].val <= arr[j].val) {
                    buffer[index] = arr[i++];
                } else {
                    buffer[index] = arr[j++];
                }
                index++;
            }
            while(i <= mid) {
                buffer[index++] = arr[i++];
            }
            while(j <= right) {
                buffer[index++] = arr[j++];
            }
            for(int k = left; k <= right; k++) {
                arr[k] = buffer[k];
            }
        }

        private int search(Node[] arr, int left, int right, long target) {
            while(left < right) {
                int mid = right - (right - left) / 2;
                if(arr[mid].val * 2 < target) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return arr[left].val * 2 < target ? left : left-1;
        }

        class Node {
            long val;
            int idx;

            Node(int v, int i) {
                val = v;
                idx = i;
            }
        }
    }
}
