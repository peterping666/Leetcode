public class _791_CustomSortString {
    class Solution {
        public String customSortString(String order, String s) {
            int[] freq = new int[26];
            for (int i = 0; i < s.length(); i++) {
                freq[s.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < order.length(); i++) {
                char c = order.charAt(i);
                while (freq[c - 'a']-- > 0) {
                    sb.append(c);
                }
            }
            for (int i = 0; i < 26; i++) {
                while (freq[i]-- > 0) {
                    sb.append((char)(i + 'a'));
                }
            }
            return sb.toString();
        }
    }
}
