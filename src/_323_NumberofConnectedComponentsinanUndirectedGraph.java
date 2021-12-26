import java.util.*;

public class _323_NumberofConnectedComponentsinanUndirectedGraph {

    class Solution1 {
        public int countComponents(int n, int[][] edges) {
            UnionFind unionFind = new UnionFind(n);
            for(int[] edge : edges) {
                unionFind.union(edge[0], edge[1]);
            }
            return unionFind.getComponentsNum();
        }

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
    }

    class Solution2 {
        public int countComponents(int n, int[][] edges) {
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
    }

    class Solution {
        public int countComponents(int n, int[][] edges) {
            List<Integer>[] graph = new List[n];

            for(int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }
            for(int[] edge : edges) {
                graph[edge[0]].add(edge[1]);
                graph[edge[1]].add(edge[0]);
            }
            boolean[] seen = new boolean[n];
            int res = 0;
            for(int i = 0; i < n; i++) {
                if(!seen[i]) {
                    dfs(graph, seen, i);
                    res++;
                }
            }
            return res;
        }

        private void dfs(List<Integer>[] graph, boolean[] seen, int cur) {
            if(seen[cur]) {
                return;
            }
            seen[cur] = true;
            for(int next : graph[cur]) {
                dfs(graph, seen, next);
            }
        }
    }
}


