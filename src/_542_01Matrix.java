import java.util.LinkedList;
import java.util.Queue;

public class _542_01Matrix {
    /**
     * Time O(m * n)
     * Space O(m * n)
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dists = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    queue.offer(new int[]{i,j});
                } else {
                    dists[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] coordinates = queue.poll();
                int row = coordinates[0];
                int col = coordinates[1];
                for(int[] dir : dirs) {
                    int newX = row + dir[0];
                    int newY = col + dir[1];
                    if(newX < 0 || newX >= n || newY < 0 || newY >= m || dists[newX][newY] <= dists[row][col] + 1) continue;
                    queue.offer(new int[]{newX, newY});
                    dists[newX][newY] = dists[row][col] + 1;
                }
            }
        }
        return dists;
    }
}
