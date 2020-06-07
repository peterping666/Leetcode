public class _424_LongestRepeatingCharacterReplacement {
    /**
     * Time O(n)
     * Space O(1)
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int max = 0, res = 0, start = 0;
        for(int i = 0; i < s.length(); i++) {
            max = Math.max(max, ++count[s.charAt(i) - 'A']);
            if(i - start + 1 - max > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            res = Math.max(res, i - start + 1);
        }
        return res;
    }
}
