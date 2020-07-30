import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class _785_IsGraphBipartite {
    class Solution1 {
        public boolean isBipartite(int[][] graph) {
            int n = graph.length;
            int[] colors = new int[n];

            for (int i = 0; i < n; i++) {              //This graph might be a disconnected graph. So check each unvisited node.
                if (colors[i] == 0 && !validColor(graph, colors, 1, i)) {
                    return false;
                }
            }
            return true;
        }

        public boolean validColor(int[][] graph, int[] colors, int color, int node) {
            if (colors[node] != 0) {
                return colors[node] == color;
            }
            colors[node] = color;
            for (int next : graph[node]) {
                if (!validColor(graph, colors, -color, next)) {
                    return false;
                }
            }
            return true;
        }
    }
    class Solution2 {
        public boolean isBipartite(int[][] graph) {
            int n = graph.length;
            int[] group = new int[n];
            for(int i = 0; i < n; i++) {
                if(group[i] != 0) {
                    continue;
                }
                Queue<Integer> q = new ArrayDeque<>();
                q.offer(i);
                group[i] = 1;
                while(!q.isEmpty()) {
                    int cur = q.poll();
                    for(int nei : graph[cur]) {
                        if(group[nei] == 0) {
                            group[nei] = -group[cur];
                            q.offer(nei);
                        } else if(group[nei] != -group[cur]) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }
    class Solution3 {
        public boolean isBipartite(int[][] graph) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int n = graph.length;
            for(int i = 0; i < n; i++) {
                if(map.containsKey(i)) {
                    continue;
                }
                Queue<Integer> q = new ArrayDeque<>();
                q.offer(i);
                map.put(i, 1);
                while(!q.isEmpty()) {
                    int cur = q.poll();
                    int curGroup = map.get(cur);
                    int neiGroup = -curGroup;
                    for(int nei : graph[cur]) {
                        if(!map.containsKey(nei)) {
                            map.put(nei, neiGroup);
                            q.offer(nei);
                        } else if(map.get(nei) != neiGroup) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }
}
