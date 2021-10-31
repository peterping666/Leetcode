import java.util.*;

public class _133_CloneGraph {
    class Solution {
        public Node cloneGraph(Node node) {
            if (node == null) {
                return null;
            }
            HashMap<Node, Node> visited = new HashMap();
            Queue<Node> queue = new ArrayDeque<>();
            queue.add(node);
            visited.put(node, new Node(node.val));
            while (!queue.isEmpty()) {
                Node cur = queue.remove();
                for (Node neighbor : cur.neighbors) {
                    if (!visited.containsKey(neighbor)) {
                        visited.put(neighbor, new Node(neighbor.val));
                        queue.add(neighbor);
                    }
                    visited.get(cur).neighbors.add(visited.get(neighbor));
                }
            }
            return visited.get(node);
        }
    }
}
