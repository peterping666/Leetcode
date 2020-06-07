public class _243_ShortestWordDistance {
    /**
     * Time O(n)
     * Space O(1)
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public int shortestDistance(String[] words, String word1, String word2) {
        int distance = words.length;
        int index1 = -1, index2 = -1;
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)) {
                index1 = i;
            } else if(words[i].equals(word2)){
                index2 = i;
            }
            if(index1 != -1 && index2 != -1) {
                distance = Math.min(distance, Math.abs(index1 - index2));
            }
        }
        return distance;
    }
}
