import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _323_NumberofConnectedComponentsinanUndirectedGraph {

    class UnionFind {
        private int[] parent;
        private int[] size;
        private int componentsNum;

        UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
                componentsNum = n;
            }
        }

        public int find(int n) {
            int root = n;
            while(root != parent[root]) {
                root = parent[root];
            }
            while(parent[n] != root) {
                int oldParent = parent[n];
                parent[n] = root;
                n = parent[oldParent];
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
            componentsNum--;
            return true;
        }

        public int getComponentsNum() {
            return componentsNum;
        }
    }

    /**
     * Union Find with class
     * Time O(n)
     * Space O(n)
     * @param n
     * @param edges
     * @return
     */
    public int countComponents1(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
        for(int[] edge : edges) {
            unionFind.union(edge[0], edge[1]);
        }
        return unionFind.getComponentsNum();
    }

    /**
     * Union Find without class
     * Time O(n)
     * Space O(n)
     * @param n
     * @param edges
     * @return
     */
    public int countComponents2(int n, int[][] edges) {
        int[] roots = new int[n];
        for(int i = 0; i < n; i++) roots[i] = i;

        for(int[] e : edges) {
            int root1 = find(roots, e[0]);
            int root2 = find(roots, e[1]);
            if(root1 != root2) {
                roots[root1] = root2;  // union
                n--;
            }
        }
        return n;
    }

    public int find(int[] roots, int id) {
        while(roots[id] != id) {
            roots[id] = roots[roots[id]];  // optional: path compression
            id = roots[id];
        }
        return id;
    }


    /**
     * DFS
     * @param n
     * @param edges
     * @return
     */
    public int countComponents3(int n, int[][] edges) {
        if (n <= 1) {
            return n;
        }
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(visited, i, adjList);
            }
        }
        return count;
    }

    public void dfs(boolean[] visited, int index, List<List<Integer>> adjList) {
        visited[index] = true;
        for (int i : adjList.get(index)) {
            if (!visited[i]) {
                dfs(visited, i, adjList);
            }
        }
    }

    /**
     * BFS
     * @param n
     * @param edges
     * @return
     */
    public int countComponents4(int n, int[][] edges) {
        if (n <= 1) {
            return n;
        }
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                Queue<Integer> queue = new LinkedList<Integer>();
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int index = queue.poll();
                    visited[index] = true;
                    for (int next : adjList.get(index)) {
                        if (!visited[next]) {
                            queue.offer(next);
                        }
                    }
                }
            }
        }

        return count;
    }
}


