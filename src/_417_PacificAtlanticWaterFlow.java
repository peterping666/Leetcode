import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _417_PacificAtlanticWaterFlow {
    /**
     * Time O(m * n)
     * Space O(m * n)
     * @param matrix
     * @return
     */
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> lists = new ArrayList<>();
        int m = matrix.length;
        if(m == 0) return lists;
        int n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        for(int i = 0; i < m; i++) {
            helper(pacific, dirs, i, 0, matrix);
            helper(atlantic, dirs, i, n-1, matrix);
        }
        for(int i = 0; i < n; i++) {
            helper(pacific, dirs, 0, i, matrix);
            helper(atlantic, dirs, m-1, i, matrix);
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    lists.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
        return lists;
    }

    private void helper(boolean[][] visited, int[][] dirs, int i, int j, int[][] matrix) {
        visited[i][j] = true;
        for(int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if(x < 0 || x >= visited.length || y < 0 || y >= visited[0].length
                    || visited[x][y] || matrix[i][j] > matrix[x][y]) continue;
            helper(visited, dirs, x, y, matrix);
        }
    }
}
