public class _389_FindtheDifference {
    /**
     * Time O(n)
     * Space O(n)
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        char c = t.charAt(0);
        for(int i = 0; i < s.length(); i++) {
            c ^= s.charAt(i);
            c ^= t.charAt(i+1);
        }
        return c;
    }
}
