public class _245_ShortestWordDistanceIII {
    /**
     * Time O(n)
     * Space O(1)
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int distance = words.length;
        int index1 = -1;
        int index2 = -1;
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)) {
                index1 = i;
            }
            if(words[i].equals(word2)) {
                if(word1.equals(word2)) {
                    index1 = index2;
                }
                index2 = i;
            }
            if(index1 != -1 && index2 != -1) {
                distance = Math.min(distance, Math.abs(index1 - index2));
            }
        }
        return distance;
    }
}
