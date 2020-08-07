package Laicode;

public class _75_NumberOfDifferentBits {
    public class Solution {
        public int diffBits(int a, int b) {
            int count = 0;
            a ^= b;
            while(a != 0) {
                a &= a - 1;
                count++;
            }
            return count;
        }
    }

}
