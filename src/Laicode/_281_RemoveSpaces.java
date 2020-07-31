package Laicode;

public class _281_RemoveSpaces {
    public class Solution {
        public String removeSpaces(String input) {
            char[] array = input.toCharArray();
            int j = 0;
            for(int i = 0; i < array.length; i++) {
                if(array[i] != ' ' || (i != 0 && array[i-1] != ' ')) {
                    array[j++] = array[i];
                }
            }
            if(j > 0 && array[j - 1] == ' ') {
                j--;
            }
            return new String(array, 0, j);
        }
    }

}
