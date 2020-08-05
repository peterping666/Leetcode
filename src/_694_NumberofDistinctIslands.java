import java.util.HashSet;
import java.util.Set;

public class _694_NumberofDistinctIslands {
    class Solution {
        public int numDistinctIslands(int[][] grid) {
            int res = 0;
            Set<String> set = new HashSet<>();
            int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[0].length; j++) {
                    if(grid[i][j] == 1) {
                        StringBuilder sb = new StringBuilder();
                        helper(grid, i, j, 0, 0, sb, dirs);
                        String s = sb.toString();
                        if(set.add(s)) {
                            res++;
                        }
                    }
                }
            }
            return res;
        }

        private void helper(int[][] grid, int i, int j, int x, int y, StringBuilder sb, int[][] dirs) {
            if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j]==0) {
                return;
            }
            grid[i][j] = 0;
            sb.append(x + "-" + y + " ");
            for(int[] dir : dirs) {
                int r = i + dir[0];
                int c = j + dir[1];
                helper(grid, r, c, x + dir[0], y + dir[1], sb, dirs);
            }

        }
    }
}
