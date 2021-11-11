import java.util.*;

public class _1443_MinimumTimetoCollectAllApplesinaTree {
    class Solution {

        public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for(int[] edge : edges) {
                graph.putIfAbsent(edge[0], new ArrayList<>());
                graph.putIfAbsent(edge[1], new ArrayList<>());
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
            }
            return helper(graph, hasApple, 0, new HashSet<>());
        }

        private int helper(Map<Integer, List<Integer>> graph, List<Boolean> hasApple, int node, Set<Integer> set) {
            set.add(node);
            int time = 0;
            if(graph.containsKey(node)) {
                for(int child : graph.get(node)) {
                    if(!set.contains(child)) {
                        time += helper(graph, hasApple, child, set);
                    }
                }
            }
            if((time > 0 || hasApple.get(node)) && node != 0) {
                time += 2;
            }
            return time;
        }
    }


}
