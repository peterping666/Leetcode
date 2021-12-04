public class _758_BoldWordsinString {
    class Solution {
        public String boldWords(String[] words, String s) {
            int n = s.length();
            boolean[] bold = new boolean[n];
            for(String word : words) {
                int start=0;
                while(start >= 0) {
                    start = s.indexOf(word, start);
                    if(start < 0) {
                        break;
                    }
                    for(int i = start; i < start + word.length(); i++) {
                        bold[i] = true;
                    }
                    start++;
                }
            }

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < n; i++) {
                if(bold[i] && (i == 0 || !bold[i-1])) {
                    sb.append("<b>");
                }
                sb.append(s.charAt(i));
                if(bold[i] && (i == n - 1 || !bold[i+1])) {
                    sb.append("</b>");
                }
            }
            return sb.toString();
        }
    }
}
