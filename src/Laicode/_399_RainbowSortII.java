package Laicode;

public class _399_RainbowSortII {
    public class Solution {
        public int[] rainbowSortII(int[] array) {
            // Write your solution here
            int j = 0, k = 0, t = array.length - 1;
            for(int i = 0; i <= t; i++) {
                if(array[i] == 0) {
                    swap(array, i, k);
                    swap(array, k++, j++);
                } else if(array[i] == 1) {
                    swap(array, i, k++);
                } else if(array[i] == 3) {
                    swap(array, i--, t--);
                }
            }
            return array;
        }

        private void swap(int[] array, int left, int right) {
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
        }
    }

}
