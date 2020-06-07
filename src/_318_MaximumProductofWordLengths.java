public class _318_MaximumProductofWordLengths {
    /**
     * Time O(n * l + n^2)
     * Space O(n)
     * @param words
     * @return
     */
    public int maxProduct(String[] words) {
        int[] bitWords = new int[words.length];
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words[i].length(); j++) {
                bitWords[i] |= (1 << words[i].charAt(j) - 'a');
            }
        }
        int ans = 0;
        for(int i = 0; i < bitWords.length; i++) {
            for(int j = i + 1; j < bitWords.length; j++) {
                if((bitWords[i] & bitWords[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }
}
