package Laicode;

public class _400_RainbowSortIII {
    public class Solution {
        public int[] rainbowSortIII(int[] array, int k) {
            // Write your solution here
            int[] indices = new int[k + 1];
            int n = array.length;
            indices[k] = n - 1;
            while(indices[k-1] <= indices[k]) {
                int cur = array[indices[k-1]];
                if(cur == k) {
                    swap(array, indices[k-1], indices[k]--);
                } else {
                    for(int i = k - 1; i > cur; i--) {
                        swap(array, indices[i]++, indices[i - 1]);
                    }
                    indices[cur]++;
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
