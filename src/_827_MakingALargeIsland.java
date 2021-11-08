import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _827_MakingALargeIsland {
    class Solution {
        public int largestIsland(int[][] grid) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 0);
            int n = grid.length;
            int colorIndex = 2;
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        int size = paint(grid, i, j, colorIndex);
                        res = Math.max(res, size);
                        map.put(colorIndex, size);
                        colorIndex++;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        Set<Integer> set = new HashSet<>();
                        set.add(i > 0 ? grid[i - 1][j] : 0);
                        set.add(i < n - 1 ? grid[i + 1][j] : 0);
                        set.add(j > 0 ? grid[i][j - 1] : 0);
                        set.add(j < n - 1 ? grid[i][j + 1] : 0);
                        int newSize = 1;
                        for (int color : set) {
                            newSize += map.get(color);
                        }
                        res = Math.max(res, newSize);
                    }
                }
            }
            return res;
        }

        private int paint(int[][] grid, int i, int j, int color) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) return 0;
            grid[i][j] = color;
            return 1 + paint(grid, i + 1, j, color) + paint(grid, i - 1, j, color) + paint(grid, i, j + 1, color) + paint(grid, i, j - 1, color);
        }
    }
}
