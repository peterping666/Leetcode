import java.util.ArrayList;
import java.util.List;

public class _1319_NumberofOperationstoMakeNetworkConnected {
    class Solution {
        public int makeConnected(int n, int[][] connections) {
            if(connections.length < n - 1) {
                return -1;
            }
            List<Integer>[] graph = new List[n];
            for(int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }
            for(int[] conn : connections) {
                graph[conn[0]].add(conn[1]);
                graph[conn[1]].add(conn[0]);
            }
            int res = 0;
            boolean[] seen = new boolean[n];
            for(int i = 0; i < n; i++) {
                if(!seen[i]) {
                    dfs(graph, i, seen);
                    res++;
                }
            }
            return res - 1;
        }

        private void dfs(List<Integer>[] graph, int cur, boolean[] seen) {
            if(seen[cur]) {
                return;
            }
            seen[cur] = true;
            for(int next : graph[cur]) {
                dfs(graph, next, seen);
            }
        }
    }
}
