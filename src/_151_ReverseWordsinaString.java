import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _151_ReverseWordsinaString {
    /**
     * Time O(n)
     * Space O(n)
     * @param s
     * @return
     */
    public String reverseWords1(String s) {
        // remove leading spaces
        s = s.trim();
        // split by multiple spaces
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    /**
     *
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        String[] strs = s.trim().split("\\s+");
        int start = 0, end = strs.length - 1;
        while(start < end) {
            String temp = strs[start];
            strs[start++] = strs[end];
            strs[end--] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
            if(i == strs.length - 1) continue;
            sb.append(" ");
        }
        return sb.toString();
    }
}
