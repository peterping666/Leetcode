public class _1047_RemoveAllAdjacentDuplicatesInString {
    class Solution {
        public String removeDuplicates(String S) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);
                if(sb.length() == 0 || sb.charAt(sb.length() - 1) != c) {
                    sb.append(c);
                } else {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
            return sb.toString();
        }
    }
}
