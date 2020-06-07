public class _168_ExcelSheetColumnTitle {
    /**
     * Time O(logn)
     * Space O(logn)
     * @param n
     * @return
     */
    public String convertToTitle1(int n) {
        StringBuilder sb = new StringBuilder();
        if(n > 26) {
            sb.append(convertToTitle1((n - 1) / 26));
        }
        sb.append((char)((n - 1) % 26 + 'A'));
        return sb.toString();
    }

    /**
     * Time O(logn)
     * Space O(logn)
     * @param n
     * @return
     */
    public String convertToTitle2(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            sb.append((char)((n - 1) % 26 + 'A'));
            n = (n - 1) / 26;
        }
        return sb.reverse().toString();
    }
}
