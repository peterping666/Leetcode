import java.util.*;

public class _210_CourseScheduleII {
    /**
     * Time O(E + V)
     * Space O(E + V)
     */
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            int[] indegree = new int[numCourses];
            Map<Integer, Set<Integer>> graph = new HashMap<>();
            for(int[] prerequisite : prerequisites) {
                indegree[prerequisite[0]]++;
                graph.putIfAbsent(prerequisite[1], new HashSet<>());
                graph.get(prerequisite[1]).add(prerequisite[0]);
            }
            Queue<Integer> queue = new ArrayDeque<>();
            for(int i = 0; i < numCourses; i++) {
                if(indegree[i] == 0) {
                    queue.offer(i);
                }
            }
            int[] result = new int[numCourses];
            int index = 0;
            while(!queue.isEmpty()) {
                int cur = queue.poll();
                result[index++] = cur;
                if(graph.containsKey(cur)) {
                    for(int course : graph.get(cur)) {
                        if(--indegree[course] == 0) {
                            queue.offer(course);
                        }
                    }
                }
            }
            return index == numCourses ? result : new int[0];
        }
    }
}
