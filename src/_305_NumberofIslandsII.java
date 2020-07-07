import java.util.ArrayList;
import java.util.List;

public class _305_NumberofIslandsII {
    /**
     * Time O(m * n + L)
     * Space O(m * n)
     * @param m
     * @param n
     * @param positions
     * @return
     */
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int[][] matrix = new int[m][n];
        UnionFind uf = new UnionFind(m, n);
        List<Integer> list = new ArrayList<>();
        for(int[] pos : positions) {
            int i = pos[0];
            int j = pos[1];
            if(uf.addLand(i, j, n, matrix)) {
                for(int[] dir : dirs) {
                    int x = dir[0] + i;
                    int y = dir[1] + j;
                    if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] == 0) continue;
                    uf.union(i*n+j, x*n+y);
                }
            }
            list.add(uf.getCount());
        }
        return list;
    }
}

class UnionFind{
    int[] parent;
    int count;
    public UnionFind(int m, int n) {
        parent = new int[m * n];
        count = 0;
    }
    public int find(int num) {
        if(parent[num] != num) {
            parent[num] = find(parent[num]);
        }
        return parent[num];
    }

    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB) return;
        parent[rootA] = rootB;
        count--;
    }

    public int getCount() {
        return count;
    }
    public boolean addLand(int i, int j, int n, int[][] matrix) {
        if(matrix[i][j] == 1) return false;
        matrix[i][j] = 1;
        int index = i * n + j;
        parent[index] = index;
        count++;
        return true;
    }
}
