import java.util.*;

public class _207_CourseSchedule {
    /**
     * Time O(E + V)
     * Spce O(E + V)
     * @return
     */
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            Map<Integer, Set<Integer>> graph = new HashMap<>();
            int[] indegree = new int[numCourses];
            for(int[] pre : prerequisites) {
                graph.putIfAbsent(pre[1], new HashSet<>());
                graph.get(pre[1]).add(pre[0]);
                indegree[pre[0]]++;
            }
            Queue<Integer> queue = new ArrayDeque<>();
            for(int i = 0; i < numCourses; i++) {
                if(indegree[i] == 0) {
                    queue.offer(i);
                }
            }
            int count = 0;
            while(!queue.isEmpty()) {
                int cur = queue.poll();
                count++;
                if(!graph.containsKey(cur)) {
                    continue;
                }
                for(int neighbor : graph.get(cur)) {
                    if(--indegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
            return count == numCourses;
        }
    }
}
