import java.util.LinkedList;
import java.util.Queue;

public class _547_FriendCircles {

    /**
     * Time O(n^2)
     * Space O(n)
     */
    class Solution1 {
        public int findCircleNum(int[][] M) {
            int n = M.length;
            int count = 0;
            boolean[] visited = new boolean[n];
            for(int i = 0; i < n; i++) {
                if(visited[i]) continue;
                visited[i] = true;
                dfs(M, i, visited);
                count++;
            }
            return count;
        }

        private void dfs(int[][] M, int i, boolean[] visited) {
            for(int j = 0; j < M.length; j++) {
                if(M[i][j] == 1 && !visited[j]) {
                    visited[j] = true;
                    dfs(M, j, visited);
                }
            }
        }
    }

    /**
     * Time O(n^2)
     * Space O(n)
     */
    class Solution2 {
        public int findCircleNum(int[][] M) {
            int n = M.length;
            int count = 0;
            boolean[] visited = new boolean[n];
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i < n; i++) {
                if(!visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    while(!queue.isEmpty()) {
                        int node = queue.poll();
                        for(int j = 0; j < n; j++) {
                            if(M[node][j] == 1 && !visited[j]) {
                                queue.offer(j);
                                visited[j] = true;
                            }
                        }
                    }
                    count++;
                }
            }
            return count;
        }
    }

    /**
     * Time O(n^2)
     * Space O(n)
     */
    class Solution {
        public int findCircleNum(int[][] M) {
            int n = M.length;
            UnionFind unionFind = new UnionFind(n);
            for(int i = 0; i < n; i++) {
                for(int j = i + 1; j < n; j++) {
                    if(M[i][j] == 1) {
                        unionFind.union(i,j);
                    }
                }
            }
            return unionFind.getCount();
        }

        class UnionFind {
            private int[] parent;
            private int[] size;
            private int count;

            // Constructor
            UnionFind(int n) {
                parent = new int[n];
                size = new int[n];
                count = n;
                for(int i = 0; i < n; i++) {
                    parent[i] = i;
                    size[i] = 1;
                }
            }

            public int find(int node) {
                int root = node;
                while(parent[root] != root) {
                    root = parent[root];
                }
                while(parent[node] != root) {
                    int oldParent = parent[node];
                    parent[node] = root;
                    node = oldParent;
                }
                return root;
            }

            public boolean union(int setA, int setB) {
                int rootA = find(setA);
                int rootB = find(setB);
                if(rootA == rootB) return false;
                if(size[rootA] > size[rootB]) {
                    parent[rootB] = rootA;
                    size[rootA] += size[rootB];
                } else {
                    parent[rootA] = rootB;
                    size[rootB] += size[rootA];
                }
                count--;
                return true;
            }

            public int getCount() {
                return count;
            }
        }
    }
}

