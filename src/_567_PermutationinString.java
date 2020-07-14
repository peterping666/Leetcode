public class _567_PermutationinString {

    class Solution {
        /**
         * Time O(n)
         * Space O(1)
         * @param s1
         * @param s2
         * @return
         */
        public boolean checkInclusion(String s1, String s2) {
            if(s2.length() < s1.length()) {
                return false;
            }
            int count = s1.length();
            int[] freq = new int[26];
            for(int i = 0; i < s1.length(); i++) {
                freq[s1.charAt(i) - 'a']++;
            }
            for(int i = 0, j = 0; i < s2.length(); i++) {
                char c = s2.charAt(i);
                if(freq[c - 'a']-- > 0) {
                    count--;
                }
                while(count == 0) {
                    if(i - j + 1 == s1.length()) {
                        return true;
                    }
                    if(freq[s2.charAt(j++) - 'a']++ >= 0) {
                        count++;
                    }
                }
            }
            return false;
        }
    }
}
