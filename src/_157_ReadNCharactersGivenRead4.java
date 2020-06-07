public class _157_ReadNCharactersGivenRead4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        boolean eof = false;
        char[] tmp = new char[4];
        int total = 0;
        while(!eof && total < n) {
            int count = read4(tmp);
            count = Math.min(count, n - total);
            eof = count < 4;
            for(int i = 0; i < count; i++) {
                buf[total++] = tmp[i];
            }
        }
        return total;
    }

    int read4(char[] tmp) {
        return 0;
    }
}
