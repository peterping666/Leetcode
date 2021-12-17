import java.util.*;

public class _1466_ReorderRoutestoMakeAllPathsLeadtotheCityZero {
    class Solution1 {
        public int minReorder(int n, int[][] connections) {
            List<Integer>[] graph = new List[n];
            for(int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }
            for(int[] c : connections) {
                graph[c[0]].add(c[1]);
                graph[c[1]].add(-c[0]);
            }
            return dfs(graph, 0, new boolean[n]);
        }

        private int dfs(List<Integer>[] graph, int cur, boolean[] seen) {
            seen[cur] = true;
            int res = 0;
            for(int next : graph[cur]) {
                if(seen[Math.abs(next)]) {
                    continue;
                }
                if(next > 0) {
                    res++;
                }
                res += dfs(graph, Math.abs(next), seen);
            }
            return res;
        }
    }


    class Solution2 {
        public int minReorder(int n, int[][] connections) {
            Set<Integer>[] to = new Set[n];
            List<Integer>[] graph = new List[n];
            for(int i = 0; i < n; i++) {
                to[i] = new HashSet<>();
                graph[i] = new ArrayList<>();
            }
            for(int[] c : connections) {
                graph[c[0]].add(c[1]);
                graph[c[1]].add(c[0]);
                to[c[0]].add(c[1]);
            }
            return dfs(graph, to, 0, new boolean[n]);
        }

        private int dfs(List<Integer>[] graph, Set<Integer>[] to, int cur, boolean[] seen) {
            seen[cur] = true;
            int res = 0;
            for(int next : graph[cur]) {
                if(seen[next]) {
                    continue;
                }
                if(!to[next].contains(cur)) {
                    res++;
                }
                res += dfs(graph, to, next, seen);
            }
            return res;
        }
    }

    class Solution3 {
        public int minReorder(int n, int[][] connections) {
            Set<Integer>[] to = new Set[n];
            List<Integer>[] graph = new List[n];
            for(int i = 0; i < n; i++) {
                to[i] = new HashSet<>();
                graph[i] = new ArrayList<>();
            }
            for(int[] c : connections) {
                graph[c[0]].add(c[1]);
                graph[c[1]].add(c[0]);
                to[c[0]].add(c[1]);
            }
            return bfs(graph, to, n);
        }

        private int bfs(List<Integer>[] graph, Set<Integer>[] to, int n) {
            boolean[] seen = new boolean[n];
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(0);
            seen[0] = true;
            int res = 0;
            while(!queue.isEmpty()) {
                int cur = queue.poll();
                for(int next : graph[cur]) {
                    if(seen[next]) {
                        continue;
                    }
                    queue.offer(next);
                    seen[next] = true;
                    if(!to[next].contains(cur)) {
                        res++;
                    }
                }
            }
            return res;
        }
    }
}
