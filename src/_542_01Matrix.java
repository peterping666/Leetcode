import java.util.ArrayDeque;
import java.util.Queue;

public class _542_01Matrix {
    /**
     * Time O(mn)
     * Space O(1)
     */
    class Solution1 {
        public int[][] updateMatrix(int[][] mat) {
            int m = mat.length, n = mat[0].length, max = m + n;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(mat[i][j] == 0) {
                        continue;
                    }
                    int left = max, top = max;
                    if(j > 0) {
                        left = mat[i][j-1];
                    }
                    if(i > 0) {
                        top = mat[i-1][j];
                    }
                    mat[i][j] = Math.min(left, top) + 1;
                }
            }

            for(int i = m-1; i >= 0; i--) {
                for(int j = n-1; j >= 0; j--) {
                    if(mat[i][j] == 0) {
                        continue;
                    }
                    int right = max, down = max;
                    if(j < n-1) {
                        right = mat[i][j+1];
                    }
                    if(i < m-1) {
                        down = mat[i+1][j];
                    }
                    mat[i][j] = Math.min(mat[i][j], Math.min(right, down) + 1);
                }
            }
            return mat;
        }
    }

    /**
     * Time O(mn)
     * Space O(mn)
     */
    class Solution2 {
        public int[][] updateMatrix(int[][] mat) {
            int m = mat.length, n = mat[0].length;
            Queue<int[]> queue = new ArrayDeque<>();
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(mat[i][j] == 0) {
                        queue.offer(new int[]{i,j});
                    } else {
                        mat[i][j] = -1;
                    }
                }
            }

            int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
            while(!queue.isEmpty()) {
                int size = queue.size();
                while(size-- > 0) {
                    int[] cur = queue.poll();
                    int i = cur[0], j = cur[1];
                    for(int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if(x < 0 || x >= m || y < 0 || y >= n || mat[x][y] != -1) {
                            continue;
                        }
                        mat[x][y] = mat[i][j] + 1;
                        queue.offer(new int[]{x,y});
                    }
                }
            }
            return mat;
        }
    }
}
