import java.util.*;

public class _399_EvaluateDivision {


    /**
     * Time O(V+E)
     * Space O(n)
     */
    class Solution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            /* Build graph. */
            Map<String, Map<String, Double>> graph = buildGraph(equations, values);
            double[] result = new double[queries.size()];

            for (int i = 0; i < queries.size(); i++) {
                result[i] = getPathWeight(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), graph);
            }
            return result;
        }

        private double getPathWeight(String start, String end, Set<String> visited, Map<String, Map<String, Double>> graph) {
            /* Rejection case. */
            if (!graph.containsKey(start)) {
                return -1.0;
            }

            /* Accepting case. */
            if (graph.get(start).containsKey(end)) {
                return graph.get(start).get(end);
            }

            visited.add(start);

            for (Map.Entry<String, Double> neighbour : graph.get(start).entrySet()) {
                if (!visited.contains(neighbour.getKey())) {
                    double productWeight = getPathWeight(neighbour.getKey(), end, visited, graph);
                    if (productWeight != -1.0) {
                        return neighbour.getValue() * productWeight;
                    }
                }
            }
            return -1.0;
        }

        private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
            Map<String, Map<String, Double>> graph = new HashMap<>();
            for (int i = 0; i < equations.size(); i++) {
                String from = equations.get(i).get(0);
                String to = equations.get(i).get(1);
                graph.putIfAbsent(from, new HashMap<>());
                graph.putIfAbsent(to, new HashMap<>());
                graph.get(from).put(to, values[i]);
                graph.get(to).put(from, 1 / values[i]);
            }
            return graph;
        }
    }
}
