package Laicode;

public class _197_ReOrderArray {
    public class Solution {
        public int[] reorder(int[] array) {
            if(array.length % 2 == 0) {
                reorder(array, 0, array.length - 1);
            } else {
                reorder(array, 0, array.length - 2);
            }
            return array;
        }

        private void reorder(int[] array, int left, int right) {
            int length = right - left + 1;
            if(length <= 2) {
                return;
            }
            int mid = left + length / 2;
            int lmid = left + length / 4;
            int rmid = left + length * 3 / 4;

            reverse(array, lmid, mid);
            reverse(array, mid, rmid);
            reverse(array, lmid, rmid);

            reorder(array, left, left + (lmid - left) * 2 - 1);
            reorder(array, left + (lmid - left) * 2, right);
        }

        private void reverse(int[] array, int l, int r) {
            int left = l;
            int right = r - 1;
            while(left < right) {
                int tmp = array[left];
                array[left++] = array[right];
                array[right--] = tmp;
            }
        }
    }

}
