import java.util.List;

public class _559_MaximumDepthNaryTree {

    /**
     * Time O(n)
     * Space O(h)
     */
    public int maxDepth(Node root) {
        if(root == null) return 0;
        int depth = 0;
        List<Node> list = root.children;
        for(int i = 0; i < list.size(); i++) {
            depth = Math.max(depth, maxDepth(list.get(i)));
        }
        return depth + 1;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
