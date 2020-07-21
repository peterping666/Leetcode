import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _1197_MinimumKnightMoves {
    class Solution {
        public int minKnightMoves(int x, int y) {
            int[][] dirs = {{1,2}, {1,-2}, {-1,2}, {-1,-2}, {2,1}, {2,-1}, {-2,1}, {-2,-1}};
            Queue<int[]> queue = new LinkedList<>();
            HashSet<String> seen = new HashSet<>();
            queue.offer(new int[]{0,0});
            seen.add("0-0");
            int res = 0;
            x = Math.abs(x);
            y = Math.abs(y);
            while(!queue.isEmpty()) {
                int size = queue.size();
                for(int i = 0; i < size; i++) {
                    int[] cur = queue.poll();
                    if(cur[0] == x && cur[1] == y) {
                        return res;
                    }
                    for(int[] dir : dirs) {
                        int row = dir[0] + cur[0];
                        int col = dir[1] + cur[1];
                        String indexStr = row + "-" + col;
                        if(row >= -1 && col >= -1 && !seen.contains(indexStr)) {
                            queue.offer(new int[]{row, col});
                            seen.add(indexStr);
                        }
                    }
                }
                res++;
            }
            return -1;
        }
    }
}
