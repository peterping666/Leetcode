import java.util.Arrays;
import java.util.HashSet;

public class _345_ReverseVowelsofaString {
    /**
     * Time O(n)
     * Space O(n)
     * @param s
     * @return
     */
    public String reverseVowels1(String s) {
        char[] chars = s.toCharArray();
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        int start = 0, end = s.length() - 1;
        while(start < end) {
            while(start < end && !vowels.contains(Character.toLowerCase(chars[start]))) {
                start++;
            }
            while(start < end && !vowels.contains(Character.toLowerCase(chars[end]))) {
                end--;
            }
            if(start < end) {
                char temp = chars[start];
                chars[start++] = chars[end];
                chars[end--] = temp;
            }
        }
        return String.valueOf(chars);
    }

    /**
     *
     * @param s
     * @return
     */
    public String reverseVowels2(String s) {
        char[] str = s.toCharArray();
        String vowels = "aeiouAEIOU";
        int l = 0;
        int r = s.length() - 1;
        while(l < r){
            while(l < r && vowels.indexOf(str[l]) == -1){
                l++;
            }
            while(l < r && vowels.indexOf(str[r]) == -1){
                r--;
            }
            char temp = str[l];
            str[l++] = str[r];
            str[r--] = temp;

        }
        return new String(str);
    }
}
