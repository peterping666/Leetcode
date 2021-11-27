public class _245_ShortestWordDistanceIII {

    class Solution {
        public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
            int res = wordsDict.length;
            int index1 = -1;
            int index2 = -1;
            for(int i = 0; i < wordsDict.length; i++) {
                if(wordsDict[i].equals(word1)) {
                    index1 = i;
                }
                if(wordsDict[i].equals(word2)) {
                    if(word1.equals(word2)) {
                        index1 = index2;
                    }
                    index2 = i;
                }
                if(index1 != -1 && index2 != -1) {
                    res = Math.min(res, Math.abs(index1 - index2));
                }
            }
            return res;
        }
    }
}
