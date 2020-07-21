public class _767_ReorganizeString {
    class Solution {
        public String reorganizeString(String S) {
            int[] counts = new int[26];
            int[] index = new int[26];
            for(int i = 0; i < S.length(); i++) {
                counts[S.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < S.length(); i++) {
                int maxCount = 0;
                char c = '#';
                for(int j = 0; j < counts.length; j++) {
                    if(counts[j] > maxCount && index[j] <= i) {
                        maxCount = counts[j];
                        c = (char)(j + 'a');
                    }
                }
                if(c == '#') {
                    return "";
                }
                counts[c - 'a']--;
                index[c - 'a'] += 2;
                sb.append(c);
            }
            return sb.toString();
        }
    }
}
