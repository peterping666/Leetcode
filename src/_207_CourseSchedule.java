import java.util.*;

public class _207_CourseSchedule {
    /**
     * Time O(E + V)
     * Spce O(E + V)
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++) {
            int out = prerequisites[i][1];
            int in = prerequisites[i][0];
            indegree[in]++;
            graph.putIfAbsent(out, new ArrayList<>());
            graph.get(out).add(in);
        }
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
                count++;
            }
        }
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            if(!graph.containsKey(cur)) continue;
            for(int neighbor : graph.get(cur)) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) {
                    queue.add(neighbor);
                    count++;
                }
            }
        }
        return count == numCourses;
    }
}
