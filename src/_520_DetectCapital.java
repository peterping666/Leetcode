public class _520_DetectCapital {
    /**
     * Time O(n)
     * Space O(1)
     * @param word
     * @return
     */
    public boolean detectCapitalUse(String word) {
        int countUp = 0;
        for(int i = 0; i < word.length(); i++) {
            if(Character.isUpperCase(word.charAt(i))) {
                countUp++;
            }
        }
        return countUp == word.length() || countUp == 0
                || (countUp == 1 && Character.isUpperCase(word.charAt(0)));
    }
}
