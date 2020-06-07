public class _171_ExcelSheetColumnNumber {
    /**
     * Time O(l)
     * Space O(1)
     * @param s
     * @return
     */
    public int titleToNumber(String s) {
        int num = 0;
        for(int i = 0; i < s.length(); i++) {
            num = num * 26 + s.charAt(i) - 'A' + 1;
        }
        return num;
    }
}
