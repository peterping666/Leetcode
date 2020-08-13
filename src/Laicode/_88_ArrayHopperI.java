package Laicode;

public class _88_ArrayHopperI {
    public class Solution {
        public boolean canJump(int[] array) {
            int max = 0;
            for(int i = 0; i < array.length; i++) {
                if(i > max) {
                    return false;
                }
                max = Math.max(max, array[i] + i);
            }
            return true;
        }
    }

}
