package Laicode;

public class _259_Move0sToTheEndII {
    public class Solution {
        public int[] moveZero(int[] array) {
            int slow = 0;
            for(int i = 0; i < array.length; i++) {
                if(array[i] != 0) {
                    array[slow++] = array[i];
                }
            }
            for(int i = slow; i < array.length; i++) {
                array[i] = 0;
            }
            return array;
        }
    }

}
