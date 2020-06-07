import java.util.*;

public class _261_GraphValidTree {
    class UnionFind1 {
        private int[] parent;

        public UnionFind1(int n) {
            parent = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public boolean union(int A, int B) {
            int rootA = find(A);
            int rootB = find(B);
            if(rootA == rootB) {
                return false;
            }
            parent[rootA] = rootB;
            return true;
        }

        public int find(int A) {
            while(parent[A] != A) {
                A = parent[A];
            }
            return A;
        }
    }

    class UnionFind2 {
        private int[] parent;
        private int[] size;

        public UnionFind2(int n) {
            parent = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int A) {
            int root = A;
            while(parent[root] != root) {
                root = parent[root];
            }
            while(A != root) {
                int oldRoot = parent[A];
                parent[A] = root;
                A = oldRoot;
            }
            return root;
        }

        public boolean union(int A, int B) {
            int rootA = find(A);
            int rootB = find(B);
            if(rootA == rootB) {
                return false;
            }
            if(size[rootA] > size[rootB]) {
                parent[rootB] = rootA;
                size[rootA] += size[rootB];
            } else {
                parent[rootA] = rootB;
                size[rootB] += size[rootA];
            }
            return true;
        }
    }

    /**
     * Time O(1)
     * Space O(1)
     * @param n
     * @param edges
     * @return
     */
    public boolean validTree1(int n, int[][] edges) {
        if(edges.length != n - 1) return false;
        UnionFind2 unionFind = new UnionFind2(n);
        for(int[] edge : edges) {
            int A = edge[0];
            int B = edge[1];
            if(!unionFind.union(A, B)) {
                return false;
            }
        }
        return true;
    }

    /**
     * DFS Iterative
     * Time O(E + V)
     * Space O(E + V)
     * @param n
     * @param edges
     * @return
     */
    public boolean validTree2(int n, int[][] edges) {
        if(edges.length != n - 1) return false;
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> seen = new HashSet<>();
        stack.push(0);
        seen.add(0);
        while(!stack.isEmpty()) {
            int cur = stack.pop();
            for(int neighbor : adjacencyList.get(cur)) {
                if(seen.contains(neighbor)) continue;
                stack.push(neighbor);
                seen.add(neighbor);
            }
        }
        return seen.size() == n;
    }

    /**
     * DFS Recursive
     */
    List<List<Integer>> adjacencyList = new ArrayList<>();
    HashSet<Integer> seen = new HashSet<>();
    public boolean validTree3(int n, int[][] edges) {
        if(edges.length != n - 1) return false;

        for(int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        dfs(0);
        return seen.size() == n;
    }

    private void dfs(int node) {
        if(seen.contains(node)) return;
        seen.add(node);
        for(int neighbor : adjacencyList.get(node)) {
            dfs(neighbor);
        }
    }

    /**
     * BFS
     * @param n
     * @param edges
     * @return
     */
    public boolean validTree4(int n, int[][] edges) {
        if(edges.length != n - 1) return false;
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> seen = new HashSet<>();
        queue.offer(0);
        seen.add(0);
        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int neighbor : adjacencyList.get(node)) {
                if(seen.contains(neighbor)) continue;
                queue.offer(neighbor);
                seen.add(neighbor);
            }
        }
        return seen.size() == n;
    }
}
