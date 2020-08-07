package Laicode;

public class _74_PowerOfTwo {
    public class Solution {
        public boolean isPowerOfTwo(int number) {
            return number > 0 && (number & (number - 1)) == 0;
        }
    }

}
