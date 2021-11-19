import java.util.*;

public class _332_ReconstructItinerary {
    /**
     * Time O(V + E)
     * Space O(E)
     */
    class Solution {
        public List<String> findItinerary(List<List<String>> tickets) {
            List<String> list = new LinkedList<>();
            HashMap<String, PriorityQueue<String>> map = new HashMap<>();
            for(List<String> ticket : tickets) {
                String from = ticket.get(0);
                String to = ticket.get(1);
                map.putIfAbsent(from, new PriorityQueue<>());
                map.get(from).offer(to);
            }
            dfs("JFK", map, list);
            return list;
        }

        private void dfs(String from, HashMap<String, PriorityQueue<String>> map, List<String> list) {
            while(map.containsKey(from) && !map.get(from).isEmpty()) {
                dfs(map.get(from).poll(), map, list);
            }
            list.add(0, from);
        }
    }
}
