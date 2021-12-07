import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _417_PacificAtlanticWaterFlow {
    /**
     * Time O(m * n)
     * Space O(m * n)
     */
    class Solution {
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            int m = heights.length, n = heights[0].length;
            boolean[][] pacific = new boolean[m][n];
            boolean[][] atlantic = new boolean[m][n];
            for(int i = 0; i < m; i++) {
                dfs(heights, i, 0, pacific, Integer.MIN_VALUE);
                dfs(heights, i, n-1, atlantic, Integer.MIN_VALUE);
            }
            for(int j = 0; j < n; j++) {
                dfs(heights, 0, j, pacific, Integer.MIN_VALUE);
                dfs(heights, m-1, j, atlantic, Integer.MIN_VALUE);
            }
            List<List<Integer>> res = new ArrayList<>();
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(pacific[i][j] && atlantic[i][j]) {
                        res.add(Arrays.asList(i, j));
                    }
                }
            }
            return res;
        }

        private void dfs(int[][] heights, int i, int j, boolean[][] ocean, int prev) {
            if(i < 0 || i >= heights.length || j < 0 || j >= heights[0].length || ocean[i][j] ||
                    heights[i][j] < prev) {
                return;
            }
            ocean[i][j] = true;
            dfs(heights, i+1, j, ocean, heights[i][j]);
            dfs(heights, i-1, j, ocean, heights[i][j]);
            dfs(heights, i, j+1, ocean, heights[i][j]);
            dfs(heights, i, j-1, ocean, heights[i][j]);
        }
    }
}
