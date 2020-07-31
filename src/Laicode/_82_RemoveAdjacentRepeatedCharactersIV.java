package Laicode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _82_RemoveAdjacentRepeatedCharactersIV {
    public class Solution {
        public String deDup(String input) {
            if(input == null || input.length() == 0) {
                return "";
            }
            char[] array = input.toCharArray();
            int j = 0;
            for(int i = 0; i < array.length; i++) {
                if(j == 0 || array[j - 1] != array[i]) {
                    array[j++] = array[i];
                } else {
                    j--;
                    while(i + 1 < array.length && array[i] == array[i + 1]) {
                        i++;
                    }
                }
            }
            return new String(array, 0, j);
        }
    }


    /**
     *
     * @param input
     * @return
     */
    public String deDup(String input) {
        if(input == null || input.length() == 0) {
            return "";
        }
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(stack.isEmpty() || c != stack.peekFirst()) {
                stack.offerFirst(c);
            } else {
                stack.pollFirst();
                while(i + 1 < input.length() && input.charAt(i) == input.charAt(i + 1)) {
                    i++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}
