import java.util.ArrayList;
import java.util.List;

public class _315_CountofSmallerNumbersAfterSelf {
    /**
     * Time O(logn)
     * Space O(n)
     */
    class Solution {
        public List<Integer> countSmaller(int[] nums) {
            int n = nums.length;
            Node[] arr = new Node[n];
            for(int i = 0; i < n; i++) {
                arr[i] = new Node(nums[i], i);
            }
            mergeSort(arr, 0, n-1, new Node[n]);
            int[] count = new int[n];
            for(Node node : arr) {
                count[node.idx] = node.count;
            }
            List<Integer> res = new ArrayList<>();
            for(int c : count) {
                res.add(c);
            }
            return res;
        }

        private void mergeSort(Node[] arr, int left, int right, Node[] buffer) {
            if(left >= right) {
                return;
            }
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid, buffer);
            mergeSort(arr, mid + 1, right, buffer);
            merge(arr, left, mid, right, buffer);
        }

        private void merge(Node[] arr, int left, int mid, int right, Node[] buffer) {
            int i = left, j = mid + 1, index = left;
            while(i <= mid && j <= right) {
                if(arr[i].val <= arr[j].val) {
                    arr[i].count += j - mid - 1;
                    buffer[index] = arr[i++];
                } else {
                    buffer[index] = arr[j++];
                }
                index++;
            }
            while(i <= mid) {
                arr[i].count += j - mid - 1;
                buffer[index++] = arr[i++];
            }
            while(j <= right) {
                buffer[index++] = arr[j++];
            }
            for(int k = left; k <= right; k++) {
                arr[k] = buffer[k];
            }
        }

        class Node {
            int val;
            int idx;
            int count;

            Node(int v, int i) {
                val = v;
                idx = i;
                count = 0;
            }
        }
    }
}
