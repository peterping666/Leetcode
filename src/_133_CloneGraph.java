import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class _133_CloneGraph {
    /**
     * Time O(n)
     * Space O(n)
     * @param node
     * @return
     */
    public Node cloneGraph1(Node node) {
        if (node == null) {
            return null;
        }
        // Hash map to save the visited node and it's respective clone
        // as key and value respectively. This helps to avoid cycles.
        HashMap<Node, Node> visited = new HashMap();
        // Put the first node in the queue
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        // Clone the node and put it in the visited dictionary.
        visited.put(node, new Node(node.val));
        // Start BFS traversal
        while (!queue.isEmpty()) {
            // Pop a node say "n" from the from the front of the queue.
            Node n = queue.remove();
            // Iterate through all the neighbors of the node "n"
            for (Node neighbor : n.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    // Clone the neighbor and put in the visited, if not present already
                    visited.put(neighbor, new Node(neighbor.val));
                    // Add the newly encountered node to the queue.
                    queue.add(neighbor);
                }
                // Add the clone of the neighbor to the neighbors of the clone node "n".
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }

        // Return the clone of the node from visited.
        return visited.get(node);
    }

    /**
     * Time O(n)
     * Space O(n)
     */
    private HashMap <Node, Node> visited = new HashMap <> ();
    public Node cloneGraph2(Node node) {
        if (node == null) {
            return node;
        }
        // If the node was already visited before.
        // Return the clone from the visited dictionary.
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        // Create a clone for the given node.
        // Note that we don't have cloned neighbors as of now, hence [].
        Node cloneNode = new Node(node.val, new ArrayList());
        // The key is original node and value being the clone node.
        visited.put(node, cloneNode);

        // Iterate through the neighbors to generate their clones
        // and prepare a list of cloned neighbors to be added to the cloned node.
        for (Node neighbor: node.neighbors) {
            cloneNode.neighbors.add(cloneGraph2(neighbor));
        }
        return cloneNode;
    }

    public Node cloneGraph3(Node node) {
        if(node == null) return null;
        Stack<Node> stack = new Stack<>();
        HashMap<Node, Node> visited = new HashMap<>();
        stack.push(node);
        visited.put(node, new Node(node.val));
        while(!stack.isEmpty()) {
            Node cur = stack.pop();
            for(Node neighbor : cur.neighbors) {
                if(!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val));
                    stack.push(neighbor);
                }
                visited.get(cur).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }
}
