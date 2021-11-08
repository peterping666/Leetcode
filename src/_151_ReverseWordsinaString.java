import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _151_ReverseWordsinaString {
    /**
     * Time O(n)
     * Space O(n)
     */
    class Solution1 {
        public String reverseWords(String s) {
            s = s.trim();
            List<String> wordList = Arrays.asList(s.split("\\s+"));
            Collections.reverse(wordList);
            return String.join(" ", wordList);
        }
    }


    class Solution2 {
        public String reverseWords(String s) {
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
}
