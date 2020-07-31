package Laicode;

public class _79_RemoveAdjacentRepeatedCharactersI {
    public class Solution {
        public String deDup(String input) {
            char[] array = input.toCharArray();
            int j = 0;
            for(int i = 0; i < array.length; i++) {
                if(j == 0 || array[i] != array[j - 1]) {
                    array[j++] = array[i];
                }
            }
            return new String(array, 0, j);
        }
    }

}
