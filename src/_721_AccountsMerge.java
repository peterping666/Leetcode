import java.util.*;

public class _721_AccountsMerge {
    class Solution {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            Map<String, Set<String>> graph = new HashMap<>();
            Map<String, String> name = new HashMap<>();
            // build graph
            for(List<String> account : accounts) {
                String username = account.get(0);
                for(int i = 1; i < account.size(); i++) {
                    graph.putIfAbsent(account.get(i), new HashSet<>());
                    name.put(account.get(i), username);
                    if(i == 1) continue;
                    graph.get(account.get(i)).add(account.get(i-1));
                    graph.get(account.get(i-1)).add(account.get(i));
                }
            }

            List<List<String>> res = new ArrayList<>();
            Set<String> visited = new HashSet<>();

            for(String email : name.keySet()) {
                List<String> emails = new LinkedList<>();
                if(visited.add(email)) {
                    dfs(graph, email, emails, visited);
                    Collections.sort(emails);
                    emails.add(0, name.get(email));
                    res.add(emails);
                }
            }
            return res;
        }

        private void dfs(Map<String, Set<String>> graph, String email, List<String> emails, Set<String> visited) {
            emails.add(email);
            for(String neighbor : graph.get(email)) {
                if(visited.add(neighbor)) {
                    dfs(graph, neighbor, emails, visited);
                }
            }
        }
    }
}
