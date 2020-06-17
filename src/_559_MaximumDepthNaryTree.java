import java.util.List;

public class _559_MaximumDepthNaryTree {

    /**
     * Time O(n)
     * Space O(h)
     */
    private int res = 0;
    public int maxDepth(Node root) {
        dfs(root, 1);
        return res;
    }

    private void dfs(Node root, int depth) {
        if(root == null) {
            return;
        }
        res = Math.max(res, depth);
        for(Node child : root.children) {
            dfs(child, depth + 1);
        }
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
