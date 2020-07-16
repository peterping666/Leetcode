import java.util.ArrayList;
import java.util.List;

public class _315_CountofSmallerNumbersAfterSelf {
    /**
     * Time O(logn)
     * Space O(n)
     * @param nums
     * @return
     */
    public List<Integer> countSmaller1(int[] nums) {
        int[] counts = new int[nums.length];
        int[] indices = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            indices[i] = i;
        }
        mergeSort(nums, indices, counts, new int[nums.length], 0, nums.length - 1);
        List<Integer> list = new ArrayList<>();
        for(int num : counts) {
            list.add(num);
        }
        return list;
    }

    private void mergeSort(int[] nums, int[] indices, int[] counts, int[] buffer,
                           int left, int right) {
        if(left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, indices, counts, buffer, left, mid);
        mergeSort(nums, indices, counts, buffer, mid + 1, right);
        merge(nums, indices, counts, buffer, left, mid, right);
    }

    private void merge(int[] nums, int[] indices, int[] counts, int[] buffer,
                       int left, int mid, int right) {
        for(int i = left; i <= right; i++) {
            buffer[i] = indices[i];
        }
        int leftIndex = left;
        int rightIndex = mid + 1;
        while(leftIndex <= mid && rightIndex <= right) {
            if(nums[buffer[leftIndex]] > nums[buffer[rightIndex]]) {
                indices[left++] = buffer[rightIndex++];
            } else {
                counts[buffer[leftIndex]] += rightIndex - mid - 1;
                indices[left++] = buffer[leftIndex++];
            }
        }
        while(leftIndex <= mid) {
            counts[buffer[leftIndex]] += rightIndex - mid - 1;
            indices[left++] = buffer[leftIndex++];
        }
    }

    /**
     * Method 2
     */
    class Solution {
        public List<Integer> countSmaller(int[] nums) {
            Pair[] pairs = new Pair[nums.length];
            for(int i = 0; i < nums.length; i++) {
                pairs[i] = new Pair(nums[i], i);
            }
            mergeSort(pairs, 0, nums.length - 1, new Pair[nums.length]);
            int[] counts = new int[nums.length];
            for(int i = 0; i < nums.length; i++) {
                Pair cur = pairs[i];
                counts[cur.idx] = cur.count;
            }
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < nums.length; i++) {
                list.add(counts[i]);
            }
            return list;
        }

        private void mergeSort(Pair[] pairs, int left, int right, Pair[] buffer) {
            if(left >= right) {
                return;
            }
            int mid = left + (right - left) / 2;
            mergeSort(pairs, left, mid, buffer);
            mergeSort(pairs, mid + 1, right, buffer);
            merge(pairs, left, mid, right, buffer);
        }

        private void merge(Pair[] pairs, int left, int mid, int right, Pair[] buffer) {
            System.arraycopy(pairs, left, buffer, left, right - left + 1);
            int leftIndex = left;
            int rightIndex = mid + 1;
            while(leftIndex <= mid && rightIndex <= right) {
                if(buffer[leftIndex].val <= buffer[rightIndex].val) {
                    buffer[leftIndex].count += rightIndex - mid - 1;
                    pairs[left++] = buffer[leftIndex++];
                } else {
                    pairs[left++] = buffer[rightIndex++];
                }
            }
            while(leftIndex <= mid) {
                buffer[leftIndex].count += rightIndex - mid - 1;
                pairs[left++] = buffer[leftIndex++];
            }
        }
    }

    class Pair {
        int val;
        int count;
        int idx;
        public Pair(int val, int i) {
            this.val = val;
            count = 0;
            idx = i;
        }
    }
}
