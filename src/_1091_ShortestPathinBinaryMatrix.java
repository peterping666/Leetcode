import javafx.util.Pair;

import java.util.*;

public class _1091_ShortestPathinBinaryMatrix {
    class Solution1 {
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

    class Solution2 {
        public int shortestPathBinaryMatrix(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            if(grid[0][0] == 1) {
                return -1;
            }
            Pair<Integer, Integer> start = new Pair<>(0, 0);
            Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();
            Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
            queue.offer(start);
            map.put(start, 1);
            int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};
            while(!queue.isEmpty()) {
                Pair<Integer, Integer> pair = queue.poll();
                int i = pair.getKey();
                int j = pair.getValue();
                if(i == m-1 && j == n-1){
                    return map.get(pair);
                }
                for(int[] dir : dirs) {
                    int x = dir[0] + i;
                    int y = dir[1] + j;
                    Pair<Integer, Integer> next = new Pair<>(x,y);
                    if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0 && !map.containsKey(next)) {
                        queue.offer(next);
                        map.put(next, map.get(pair) + 1);
                    }
                }
            }
            return -1;
        }
    }
}
