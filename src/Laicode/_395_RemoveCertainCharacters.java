package Laicode;

import java.util.HashSet;
import java.util.Set;

public class _395_RemoveCertainCharacters {
    public class Solution {
        public String remove(String input, String t) {
            Set<Character> set = new HashSet<>();
            for(int i = 0; i < t.length(); i++) {
                set.add(t.charAt(i));
            }
            char[] charArray = input.toCharArray();
            int j = 0;
            for(int i = 0; i < charArray.length; i++) {
                if(!set.contains(charArray[i])) {
                    charArray[j++] = charArray[i];
                }
            }
            return new String(charArray, 0, j);
        }
    }

}
