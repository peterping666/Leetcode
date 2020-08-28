import java.util.*;

public class _210_CourseScheduleII {
    /**
     * Time O(E + V)
     * Space O(E + V)
     * @return
     */
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            int[] res = new int[numCourses];
            Map<Integer, Integer> indegree = new HashMap<>();
            Map<Integer, Set<Integer>> graph = new HashMap<>();
            for(int[] pre : prerequisites) {
                indegree.put(pre[0], indegree.getOrDefault(pre[0], 0) + 1);
                graph.putIfAbsent(pre[1], new HashSet<>());
                graph.get(pre[1]).add(pre[0]);
            }
            Queue<Integer> queue = new ArrayDeque<>();
            int index = 0;
            for(int i = 0; i < numCourses; i++) {
                if(!indegree.containsKey(i)) {
                    queue.offer(i);
                }
            }
            while(!queue.isEmpty()) {
                int course = queue.poll();
                res[index++] = course;
                if(!graph.containsKey(course)) {
                    continue;
                }
                for(int neighbor : graph.get(course)) {
                    indegree.put(neighbor, indegree.get(neighbor) - 1);
                    if(indegree.get(neighbor) == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
            return index == numCourses ? res : new int[0];
        }
    }
}
