public class _510_InorderSuccessorinBSTII {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    /**
     * Time O(n)
     * Space O(1)
     * @param node
     * @return
     */
    public Node inorderSuccessor(Node node) {
        if(node.right != null) {
            node = node.right;
            while(node.left != null) {
                node = node.left;
            }
            return node;
        }
        while(node.parent != null && node != node.parent.left) {
            node = node.parent;
        }
        return node.parent;
    }
}
