package Laicode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _132_DeepCopyUndirectedGraph {
    public class Solution {
        public List<GraphNode> copy(List<GraphNode> graph) {
            Map<GraphNode, GraphNode> map = new HashMap<>();
            List<GraphNode> res = new ArrayList<>();
            for(GraphNode node : graph) {
                if(!map.containsKey(node)) {
                    map.put(node, new GraphNode(node.key));
                }
                GraphNode copy = map.get(node);
                for(GraphNode neighbor : node.neighbors) {
                    if(!map.containsKey(neighbor)) {
                        map.put(neighbor, new GraphNode(neighbor.key));
                    }
                    copy.neighbors.add(map.get(neighbor));
                }
                res.add(copy);
            }
            return res;
        }
    }

    class GraphNode {
        public int key;
        public List<GraphNode> neighbors;
        public GraphNode(int key) {
            this.key = key;
            this.neighbors = new ArrayList<GraphNode>();
        }
    }
}
