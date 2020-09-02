package Laicode;

public class _276_GetCountArray {
    public class Solution {
        public int[] countArray(int[] array) {
            int[] count = new int[array.length];
            int[] indices = getIndices(array);
            mergeSort(array, count, new int[array.length], indices, 0, array.length - 1);
            return count;
        }

        private int[] getIndices(int[] array) {
            int[] indices = new int[array.length];
            for(int i = 0; i < array.length; i++) {
                indices[i] = i;
            }
            return indices;
        }

        private void mergeSort(int[] array, int[] count, int[] buffer, int[] indices, int left, int right) {
            if(left >= right) {
                return;
            }
            int mid = left + (right - left) / 2;
            mergeSort(array, count, buffer, indices, left, mid);
            mergeSort(array, count, buffer, indices, mid + 1, right);
            merge(array, count, buffer, indices, left, mid, right);
        }

        private void merge(int[] array, int[] count, int[] buffer, int[] indices, int left, int mid, int right) {
            for(int i = left; i <= right; i++) {
                buffer[i] = indices[i];
            }
            int leftIndex = left;
            int rightIndex = mid + 1;
            while(leftIndex <= mid) {
                if(rightIndex > right || array[buffer[leftIndex]] <= array[buffer[rightIndex]]) {
                    count[buffer[leftIndex]] += rightIndex - mid - 1;
                    indices[left++] = buffer[leftIndex++];
                } else {
                    indices[left++] = buffer[rightIndex++];
                }
            }
        }
    }

}
