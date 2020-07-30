public class _1047_RemoveAllAdjacentDuplicatesInString {
    class Solution1 {
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

    class Solution2 {
        public String removeDuplicates(String S) {
            char[] res = S.toCharArray();
            int j = 0;
            for(int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);
                if(j == 0 || res[j-1] != c) {
                    res[j++] = S.charAt(i);
                } else {
                    j--;
                }
            }
            return new String(res, 0, j);
        }
    }
}
