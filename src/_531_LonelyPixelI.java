public class _531_LonelyPixelI {
    /**
     * Time O(m * n)
     * Space O(n or m)
     * @param picture
     * @return
     */
    public int findLonelyPixel(char[][] picture) {
        int m = picture.length;
        int n = picture[0].length;
        int[] col = new int[n];
        int[] row = new int[m];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(picture[i][j] == 'B') {
                    col[j]++;
                    row[i]++;
                }
            }
        }
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(picture[i][j] == 'B' && row[i] == 1 && col[j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
