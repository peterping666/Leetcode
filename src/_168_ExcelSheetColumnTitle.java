public class _168_ExcelSheetColumnTitle {

    /**
     * Time O(logn)
     */
    class Solution1 {
        public String convertToTitle(int columnNumber) {
            StringBuilder sb = new StringBuilder();
            while(columnNumber > 0) {
                sb.append((char)((columnNumber - 1) % 26 + 'A'));
                columnNumber = (columnNumber - 1) / 26;
            }
            return sb.reverse().toString();
        }
    }

    class Solution2 {
        public String convertToTitle(int columnNumber) {
            StringBuilder sb = new StringBuilder();
            if(columnNumber > 26) {
                sb.append(convertToTitle((columnNumber - 1) / 26));
            }
            sb.append((char)((columnNumber - 1) % 26 + 'A'));
            return sb.toString();
        }
    }
}
