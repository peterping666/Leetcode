import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class _498_DiagonalTraverse {
    class Solution1 {
        public int[] findDiagonalOrder(int[][] mat) {
            if (mat == null || mat.length == 0) {
                return new int[0];
            }

            int row = 0, col = 0, pos = 0, m = mat.length, n=mat[0].length, res [] = new int[m * n];

            for (pos = 0; pos < m * n; pos++) {
                res[pos] = mat[row][col];
                if ((row + col) % 2 == 0) {
                    if (col == n-1) {
                        row++;
                    }
                    else if (row == 0) {
                        col++;
                    }
                    else {
                        row--;
                        col++;
                    }

                } else {
                    if (row == m-1) { col++; }
                    else if (col == 0) { row++; }
                    else { row++; col--; }
                }
            }
            return res;
        }
    }

    class Solution2 {
        public int[] findDiagonalOrder(int[][] mat) {
            TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

            int rows = mat.length;
            int cols = mat[0].length;

            for(int i=0;i<rows;i++) {
                for(int j=0;j<cols;j++) {
                    if(!map.containsKey(i+j)) {
                        map.put(i+j, new ArrayList<Integer>());
                    }
                    map.get(i+j).add(mat[i][j]);
                }
            }

            int[] result = new int[rows*cols];
            int idx = 0;
            for(int i : map.keySet()) {
                ArrayList<Integer> list = map.get(i);
                if(i % 2 == 0) {
                    Collections.reverse(list);
                }
                for(int number : list) {
                    result[idx++] = number;
                }
            }
            return result;
        }
    }
}
