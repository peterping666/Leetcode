import java.util.*;

public class _886_PossibleBipartition {
    class Solution1 {
        public boolean possibleBipartition(int N, int[][] dislikes) {
            int[] color = new int[N + 1];
            List<Integer>[] graph = new List[N + 1];
            for(int i = 0; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            for(int[] d : dislikes) {
                graph[d[0]].add(d[1]);
                graph[d[1]].add(d[0]);
            }

            for(int i = 1; i <= N; i++) {
                if(color[i] == 0) {
                    color[i] = 1;
                    Queue<Integer> q = new LinkedList<>();
                    q.add(i);
                    while(!q.isEmpty()) {
                        int cur = q.poll();
                        for(int nb : graph[cur]) {
                            if(color[nb] == 0) {
                                color[nb] = -color[cur];
                                q.add(nb);
                            } else {
                                if(color[nb] == color[cur]) return false;
                            }
                        }
                    }
                }
            }
            return true;
        }
    }

    class Solution2 {
        public boolean possibleBipartition(int N, int[][] dislikes) {
            Map<Integer, Set<Integer>> graph = new HashMap<>();
            for(int[] dislike : dislikes) {
                int num1 = dislike[0];
                int num2 = dislike[1];
                graph.putIfAbsent(num1, new HashSet<>());
                graph.get(num1).add(num2);
                graph.putIfAbsent(num2, new HashSet<>());
                graph.get(num2).add(num1);
            }
            Set<Integer> visited = new HashSet<>();
            Map<Integer, Integer> group = new HashMap<>();
            for(int num : graph.keySet()) {
                if(visited.add(num)) {
                    group.put(num, 1);
                    if(!dfs(graph, num, visited, group)) {
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean dfs(Map<Integer, Set<Integer>> graph, int num, Set<Integer> visited,
                            Map<Integer, Integer> group) {

            for(int next : graph.get(num)) {
                if(group.containsKey(next)) {
                    if(group.get(num) == group.get(next)) {
                        return false;
                    }
                } else {
                    group.put(next, -group.get(num));
                }
                if(visited.add(next)) {
                    if(!dfs(graph, next, visited, group)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    class Solution3 {
        public boolean possibleBipartition(int N, int[][] dislikes) {
            Map<Integer, Set<Integer>> graph = new HashMap<>();
            for(int[] dislike : dislikes) {
                int num1 = dislike[0];
                int num2 = dislike[1];
                graph.putIfAbsent(num1, new HashSet<>());
                graph.get(num1).add(num2);
                graph.putIfAbsent(num2, new HashSet<>());
                graph.get(num2).add(num1);
            }
            Set<Integer> visited = new HashSet<>();
            Map<Integer, Integer> group = new HashMap<>();
            for(int num : graph.keySet()) {
                if(visited.add(num)) {
                    Queue<Integer> q = new ArrayDeque<>();
                    q.offer(num);
                    while(!q.isEmpty()) {
                        int cur = q.poll();
                        if(!group.containsKey(cur)) {
                            group.put(cur, 1);
                        }
                        for(int next : graph.get(cur)) {
                            if(visited.add(next)) {
                                group.put(next, -group.get(cur));
                                q.offer(next);
                            } else {
                                if(group.get(cur) == group.get(next)) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
            return true;
        }
    }
}
