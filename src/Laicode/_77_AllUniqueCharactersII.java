package Laicode;

public class _77_AllUniqueCharactersII {
    public class Solution {
        public boolean allUnique(String word) {
            int[] array = new int[8];
            for(int i = 0; i < word.length(); i++) {
                int value = word.charAt(i);
                int index = value / 32;
                int offset = value % 32;
                if((array[index] & (1 << offset)) != 0) {
                    return false;
                } else {
                    array[index] |= (1 << offset);
                }
            }
            return true;
        }
    }

}
