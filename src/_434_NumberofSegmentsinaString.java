public class _434_NumberofSegmentsinaString {
    /**
     * Time O(n)
     * Space O(n)
     * @param s
     * @return
     */
    public int countSegments1(String s) {
        String str = s.trim();
        if(str.equals("")) return 0;
        return str.split("\\s+").length;
    }


    /**
     * Time O(n)
     * Space O(1)
     * @param s
     * @return
     */
    public int countSegments2(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if((i == 0 || s.charAt(i- 1) == ' ') && s.charAt(i) != ' ') {
                count++;
            }
        }
        return count;
    }
}
