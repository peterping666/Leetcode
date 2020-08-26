package Laicode;

import java.util.Arrays;

public class _25_KSmallestInUnsortedArray {
    public class Solution {
        public int[] kSmallest(int[] array, int k) {
            int[] res = new int[k];
            if(array == null || array.length == 0 || k == 0) {
                return res;
            }
            quickSelect(array, 0, array.length - 1, k - 1);
            res = Arrays.copyOf(array, k);
            Arrays.sort(res);
            return res;
        }

        private void quickSelect(int[] array, int left, int right, int target) {
            int mid = partition(array, left, right);
            if(mid == target) {
                return;
            } else if(mid > target) {
                quickSelect(array, left, mid - 1, target);
            } else {
                quickSelect(array, mid + 1, right, target);
            }
        }

        private int partition(int[] array, int left, int right) {
            int pivot = array[right];
            int leftBound = left;
            int rightBound = right - 1;
            while(leftBound <= rightBound) {
                if(array[leftBound] < pivot) {
                    leftBound++;
                } else if(array[rightBound] >= pivot) {
                    rightBound--;
                } else {
                    swap(array, leftBound++, rightBound--);
                }
            }
            swap(array, leftBound, right);
            return leftBound;
        }

        private void swap(int[] array, int left, int right) {
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
        }
    }

}
