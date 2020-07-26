import java.util.LinkedList;
import java.util.Queue;

public class _1293_ShortestPathinaGridwithObstaclesElimination {
    class Solution {
        public int shortestPath(int[][] grid, int k) {
            int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
            int m = grid.length;
            int n = grid[0].length;
            Queue<Node> q = new LinkedList<>();
            boolean[][][] seen = new boolean[m][n][k + 1];
            q.offer(new Node(0, 0, k, 0));
            seen[0][0][k] = true;
            int res = Integer.MAX_VALUE;
            while(!q.isEmpty()) {
                Node cur = q.poll();
                if(cur.row == m - 1 && cur.col == n - 1) {
                    res = Math.min(res, cur.dist);
                }
                for(int[] dir : dirs) {
                    int x = cur.row + dir[0];
                    int y = cur.col + dir[1];
                    if(x < 0 || x >= m || y < 0 || y >= n) {
                        continue;
                    }
                    int obs = cur.obstacles - (grid[x][y] == 1 ? 1 : 0);
                    if(obs < 0 || seen[x][y][obs]) continue;
                    q.offer(new Node(x, y, obs, cur.dist + 1));
                    seen[x][y][obs] = true;
                }
            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }

        class Node{
            int row;
            int col;
            int obstacles;
            int dist;

            Node(int r, int c, int o, int d) {
                row = r;
                col = c;
                obstacles = o;
                dist = d;
            }
        }
    }
}
