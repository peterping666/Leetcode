import java.util.HashSet;
import java.util.Set;

public class _694_NumberofDistinctIslands {

    class Solution1 {
        public int numDistinctIslands(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            Set<String> island = new HashSet<>();
            boolean[][] seen = new boolean[m][n];

            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(grid[i][j] == 1 && !seen[i][j]) {
                        StringBuilder sb = new StringBuilder();
                        helper(grid, i, j, seen, 0, 0, sb);
                        island.add(sb.toString());
                    }
                }
            }
            return island.size();
        }

        private void helper(int[][] grid, int i, int j, boolean[][] seen, int x, int y, StringBuilder sb) {
            if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || seen[i][j] || grid[i][j] == 0) {
                return;
            }
            sb.append(x + "#" + y + "|");
            seen[i][j] = true;
            helper(grid, i+1, j, seen, x+1, y, sb);
            helper(grid, i-1, j, seen, x-1, y, sb);
            helper(grid, i, j-1, seen, x, y-1, sb);
            helper(grid, i, j+1, seen, x, y+1, sb);
        }
    }

    class Solution2 {
        public int numDistinctIslands(int[][] grid) {
            Set<String> set = new HashSet<>();
            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[i].length; j++) {
                    if(grid[i][j] == 1) {
                        StringBuilder sb = new StringBuilder();
                        dfs(grid, i, j, sb, "o"); // origin
                        set.add(sb.toString());
                    }
                }
            }
            return set.size();
        }
        private void dfs(int[][] grid, int i, int j, StringBuilder sb, String dir) {
            if(i < 0 || i == grid.length || j < 0 || j == grid[i].length || grid[i][j] == 0) {
                return;
            }
            sb.append(dir);
            grid[i][j] = 0;
            dfs(grid, i-1, j, sb, "u");
            dfs(grid, i+1, j, sb, "d");
            dfs(grid, i, j-1, sb, "l");
            dfs(grid, i, j+1, sb, "r");
            sb.append("b"); // back
        }
    }
}
