package Laicode;

public class _253_LongestSubstringWithoutRepeatingCharacters {
    public class Solution {
        public int longest(String input) {
            int res = 0;
            int[] count = new int[26];
            char[] array = input.toCharArray();
            for(int i = 0, j = 0; i < array.length; i++) {
                int index = array[i] - 'a';
                count[index]++;
                while(count[index] > 1) {
                    count[array[j++] - 'a']--;
                }
                res = Math.max(res, i - j + 1);
            }
            return res;
        }
    }

}
