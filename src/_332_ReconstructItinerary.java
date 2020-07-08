import java.util.*;

public class _332_ReconstructItinerary {
    /**
     * Time O(V + E)
     * Space O(E)
     * @param tickets
     * @return
     */
    public List<String> findItinerary1(List<List<String>> tickets) {
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

    /**
     *
     * @param tickets
     * @return
     */
    public List<String> findItinerary2(List<List<String>> tickets) {
        List<String> list = new LinkedList<>();
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        for(List<String> ticket : tickets) {
            map.computeIfAbsent(ticket.get(0),
                    k -> new PriorityQueue<>()).add(ticket.get(1));
        }
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while(!stack.empty()) {
            while(map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty()) {
                stack.push(map.get(stack.peek()).poll());
            }
            list.add(0, stack.pop());
        }
        return list;
    }
}
