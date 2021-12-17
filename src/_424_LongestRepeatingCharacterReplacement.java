public class _424_LongestRepeatingCharacterReplacement {
    /**
     * Time O(n)
     * Space O(1)
     */
    class Solution {
        public int characterReplacement(String s, int k) {
            int res = 0, maxCount = 0;
            int[] count = new int[26];
            for(int i = 0, j = 0; i < s.length(); i++) {
                maxCount = Math.max(maxCount, ++count[s.charAt(i) - 'A']);
                if(i - j + 1 - maxCount > k) {
                    count[s.charAt(j++) - 'A']--;
                }
                res = Math.max(res, i - j + 1);
            }
            return res;
        }
    }
}
