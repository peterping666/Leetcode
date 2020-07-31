package Laicode;

public class _68_MissingNumberI {
    public class Solution {
        public int missing(int[] array) {
            int res = array.length + 1;
            for(int i = 1; i < array.length + 1; i++) {
                res ^= array[i - 1];
                res ^= i;
            }
            return res;
        }
    }

}
