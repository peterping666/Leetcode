public class _567_PermutationinString {

    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int n = s1.length();
            int[] freq = new int[26];
            for(int i = 0; i < n; i++) {
                freq[s1.charAt(i) - 'a']++;
            }
            int count = 0;
            for(int i = 0, j = 0; i < s2.length(); i++) {
                if(freq[s2.charAt(i) - 'a']-- > 0) {
                    count++;
                }
                if(i - j + 1 > n && ++freq[s2.charAt(j++) - 'a'] > 0) {
                    count--;
                }
                if(count == n) {
                    return true;
                }
            }
            return false;
        }
    }
}
