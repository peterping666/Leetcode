import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _582_KillProcess {
    class Solution {
        public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for(int i = 0; i < pid.size(); i++) {
                graph.putIfAbsent(ppid.get(i), new ArrayList<>());
                graph.get(ppid.get(i)).add(pid.get(i));
            }
            List<Integer> res = new ArrayList<>();
            dfs(graph, res, kill);
            return res;
        }

        private void dfs(Map<Integer, List<Integer>> graph, List<Integer> res, int cur) {
            res.add(cur);
            if(graph.containsKey(cur)) {
                for(int next : graph.get(cur)) {
                    dfs(graph, res, next);
                }
            }
        }
    }
}
