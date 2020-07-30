package Laicode;

import java.util.*;

public class _56_Bipartite {

    public class GraphNode {
        public int key;
        public List<GraphNode> neighbors;
        public GraphNode(int key) {
            this.key = key;
            this.neighbors = new ArrayList<GraphNode>();
        }
    }

    public class Solution {
        public boolean isBipartite(List<GraphNode> graph) {
            HashMap<GraphNode, Integer> map = new HashMap<>();
            Queue<GraphNode> q = new LinkedList<>();
            for(GraphNode node : graph) {
                if(map.containsKey(node)) {
                    continue;
                }
                q.offer(node);
                map.put(node, 0);
                while(!q.isEmpty()) {
                    GraphNode cur = q.poll();
                    int curGroup = map.get(cur);
                    int neiGroup = 1 - curGroup;
                    for(GraphNode nei : cur.neighbors) {
                        if(!map.containsKey(nei)) {
                            map.put(nei, neiGroup);
                            q.offer(nei);
                        } else if(map.get(nei) != neiGroup) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }
}
