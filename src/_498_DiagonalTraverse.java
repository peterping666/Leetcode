public class _498_DiagonalTraverse {
    class Solution {
        public int[] findDiagonalOrder(int[][] mat) {
            int m = mat.length, n = mat[0].length;
            int[] res = new int[m * n];
            int index = 0;
            for(int i = 0; i < m + n - 1; i++) {
                if(i % 2 == 0) {
                    int x = i < m ? i : m - 1;
                    int y = i < m ? 0 : i + 1 - m;
                    while(x >= 0 && y < n) {
                        res[index++] = mat[x--][y++];
                    }
                } else {
                    int x = i < n ? 0 : i + 1 - n;
                    int y = i < n ? i : n - 1;
                    while(x < m && y >= 0) {
                        res[index++] = mat[x++][y--];
                    }
                }
            }
            return res;
        }
    }
}
