import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _323_NumberofConnectedComponentsinanUndirectedGraph {

    class UnionFind {
        private int[] parent;
        private int componentNum;

        UnionFind(int n) {
            parent = new int[n];
            componentNum = n;
            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int i) {
            if(i != parent[i]) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public void union(int a, int b) {
            int roota = find(a);
            int rootb = find(b);
            if(roota == rootb) return;
            parent[roota] = rootb;
            componentNum--;
        }

        public int getComponentsNum() {
            return componentNum;
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


