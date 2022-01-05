import java.util.*;

public class _399_EvaluateDivision {

    /**
     * Time O(V+E)
     * Space O(V+E)
     */
    class Solution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            Map<String, Map<String, Double>> graph = new HashMap<>();
            for(int i = 0; i < equations.size(); i++) {
                String from = equations.get(i).get(0);
                String to = equations.get(i).get(1);
                graph.putIfAbsent(from, new HashMap<>());
                graph.putIfAbsent(to, new HashMap<>());
                graph.get(from).put(to, values[i]);
                graph.get(to).put(from, 1/values[i]);
            }
            int n = queries.size();
            double[] res = new double[n];
            for(int i = 0; i < n; i++) {
                res[i] = dfs(graph, queries.get(i).get(0), queries.get(i).get(1), new HashSet<>());
            }
            return res;
        }

        private double dfs(Map<String, Map<String, Double>> graph, String cur, String target, Set<String> seen) {
            if(!graph.containsKey(cur) || !seen.add(cur)) {
                return -1;
            }
            if(graph.get(cur).containsKey(target)) {
                return graph.get(cur).get(target);
            }
            for(String next : graph.get(cur).keySet()) {
                double val = dfs(graph, next, target, seen);
                if(val != -1) {
                    return val * graph.get(cur).get(next);
                }
            }
            return -1;
        }
    }
}
