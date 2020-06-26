import java.util.*;

public class _210_CourseScheduleII {
    /**
     * Time O(E + V)
     * Space O(E + V)
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int[] prerequisite : prerequisites) {
            graph.putIfAbsent(prerequisite[1], new ArrayList<>());
            graph.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
                list.add(i);
            }
        }
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            if(!graph.containsKey(cur)) continue;
            for(int neighbor : graph.get(cur)) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                    list.add(neighbor);
                }
            }
        }
        if(list.size() != numCourses) return new int[0];
        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
