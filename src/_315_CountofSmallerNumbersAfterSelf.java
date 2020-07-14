import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _315_CountofSmallerNumbersAfterSelf {
    /**
     * Time O(logn)
     * Space O(n)
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        int n;
        if (nums == null || (n = nums.length) == 0) {
            return new ArrayList<>();
        }

        // Merge sort indices instead of values
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        int[] tmpIndices = new int[n];
        int[] counts = new int[n];
        mergeSort(nums, indices, tmpIndices, counts, 0, n - 1);

        List<Integer> result = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            result.add(counts[i]);
        }
        return result;
    }

    private void mergeSort(int[] nums, int[] indices, int[] tmpIndices, int[] counts, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        mergeSort(nums, indices, tmpIndices, counts, left, mid);
        mergeSort(nums, indices, tmpIndices, counts, mid + 1, right);
        merge(nums, indices, tmpIndices, counts, left, mid, right);
    }

    private void merge(int[] nums, int[] indices, int[] tmpIndices, int[] counts, int left, int mid, int right) {
        int leftIndex = left;
        int rightIndex = mid + 1;
        int rightCount = 0;
        int sortedIndex = left;
        while (leftIndex <= mid && rightIndex <= right) {
            if (nums[indices[leftIndex]] > nums[indices[rightIndex]]) {
                tmpIndices[sortedIndex] = indices[rightIndex];
                // Increase rightCount if left value is bigger than right value
                rightCount++;
                rightIndex++;
            } else {
                tmpIndices[sortedIndex] = indices[leftIndex];
                // If left value is smaller, increase the counts by rightCount found so far
                counts[indices[leftIndex]] += rightCount;
                leftIndex++;
            }
            sortedIndex++;
        }
        while (leftIndex <= mid) {
            // If there are remaining left values, increase their counts by adding rightCount
            tmpIndices[sortedIndex] = indices[leftIndex];
            counts[indices[leftIndex]] += rightCount;
            leftIndex++;
            sortedIndex++;
        }
        if (rightIndex <= right) {
            System.arraycopy(indices, rightIndex, tmpIndices, sortedIndex, right - rightIndex + 1);
        }
        System.arraycopy(tmpIndices, left, indices, left, right - left + 1);
    }
    class Solution {
        /**
         * Time O(n^2)
         * Space O(n)
         * @param nums
         * @return
         */
        public List<Integer> countSmaller(int[] nums) {
            List<Integer> res = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            for(int i = nums.length - 1; i >= 0; i--) {
                int index = insertIndex(list, nums[i]);
                res.add(0, index);
                list.add(index, nums[i]);
            }
            return res;
        }

        private int insertIndex(List<Integer> list, int num) {
            if(list.size() == 0) return 0;
            int left = 0;
            int right = list.size() - 1;
            while(left <= right) {
                int mid = left + (right - left) / 2;
                if(list.get(mid) >= num) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
}
