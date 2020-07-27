import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _1091_ShortestPathinBinaryMatrix {
    class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            if(grid[0][0] == 1) {
                return -1;
            }
            int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};
            int m = grid.length;
            int target = (m-1) * m + m - 1;
            Queue<Integer> q = new LinkedList<>();
            HashMap<Integer, Integer> seen = new HashMap<>();
            q.offer(0);
            seen.put(0, 1);
            while(!q.isEmpty()) {
                int cur = q.poll();
                if(cur == target) {
                    return seen.get(cur);
                }
                int r = cur / m;
                int c = cur % m;
                for(int[] dir : dirs) {
                    int x = r + dir[0];
                    int y = c + dir[1];
                    int index = x * m + y;
                    if(x < 0 || x >= m || y < 0 || y >= m || grid[x][y] == 1 || seen.containsKey(index)) {
                        continue;
                    }
                    q.offer(index);
                    seen.put(index, seen.get(cur) + 1);
                }
            }
            return -1;
        }
    }
}
